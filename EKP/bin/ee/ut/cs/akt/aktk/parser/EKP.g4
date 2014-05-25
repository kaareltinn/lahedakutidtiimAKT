grammar EKP;

programm
    :   lauseteJada
    ;

lauseteJada
    :   (lause ';')*
    ;

lause
    :   ifLause
    |   whileLause
    |   omistamine
    |   muutujaDeklaratsioon
    |   avaldis
    |   '{' lauseteJada '}'
    | function
    ;

ifLause
    :   'kui' '(' avaldis ')' '{' lauseteJada '}' ('muidu' '{' lauseteJada '}')?
    ;

whileLause
    :   'korda' '(' avaldis ')' '{' lauseteJada '}'
    ;

omistamine
    :   MuutujaNimi '=' avaldis
    ;

muutujaDeklaratsioon
    :   dataType MuutujaNimi /*(':' tyyp)?*/ ('=' avaldis)?
    ;

dataType
    : 'täisarv'
    | 'ujukomaarv'
    | 'sõne'
    ;

function
    : 'funktsioon' dataType MuutujaNimi '(' (muutujaDeklaratsioon (',' muutujaDeklaratsioon)*)* ')' '{' lauseteJada 'tagasta' avaldis ';' '}'
    ;

avaldis
    :   avaldis5
    ;

avaldis5
    :   avaldis4
            ('>'|'<'|'>='|'<='|'=='|'!=') avaldis4      # Vordlemine
    |   avaldis4                                        # TriviaalneAvaldis5
    ;

avaldis4
    :   avaldis4 ('+'|'-') avaldis3                     # LiitmineLahutamine
    |   avaldis3                                        # TriviaalneAvaldis4
    ;

avaldis3
    :   avaldis3 ('*'|'/') avaldis2                     # KorrutamineJagamine
    |   avaldis2                                        # TriviaalneAvaldis3
    ;

avaldis2
    :   '-' avaldis2                                    # UnaarneMiinus
    |   avaldis1                                        # TriviaalneAvaldis2
    ;

avaldis1
    :   MuutujaNimi '(' (avaldis (',' avaldis)*)? ')'   # FunktsiooniValjakutse
    |   avaldis0                                        # TriviaalneAvaldis1
    ;

avaldis0
    :   MuutujaNimi		# MuutujaNimiR		// Lisasin nende märgendite nimede    
    |   Arvuliteraal	# ArvuliteraalR     // lõppu R, et need ei langeks kokku
    |   Soneliteraal	# SoneliteraalR     // lekseri reeglite nimedega.
    |   '(' avaldis ')'	# Suluavaldis
    ;

MuutujaNimi
    :   [a-zäõüöžšA-ZÕÄÖÜŽŠ][a-zÕÄÖÜõäöüžšŽŠA-Z0-9_]*
    ;

Arvuliteraal
    :   ('0'|[1-9][0-9]*)('.'[0-9]+)?
    ;

Soneliteraal
    :   '"' ~["\n\r]* '"' // Tildega saab väljendada eitust.
    ;                     // Siin ~["\n\r] tähistab suvalist tähte
                          // mis pole jutumärk ega reavahetuse sümbol.

Kommentaar
    :   '/*' .*? '*/' -> skip
    ;

Rida_Kommentaar
    :   '//' ~[\r\n]* -> skip
    ;
Whitespace
    :   [ \t\r\n]+ -> skip
    ;

