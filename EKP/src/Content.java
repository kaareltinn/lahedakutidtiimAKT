import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuListener;

import ee.ut.cs.akt.aktk.compiler.AKTKc;


public class Content extends JPanel {
	
	private JEditorPane editorPane;
	private JEditorPane consolePane;
	private File savedFile;
	
	public Content(){
		setLayout(new BorderLayout());
		JMenuBar menuBar = getMenuBar();
		editorPane = new JEditorPane();
        JScrollPane editorScrollPane = new JScrollPane(editorPane);
        editorScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        editorScrollPane.setMinimumSize(new Dimension(200, 200));
        editorScrollPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Koodifail"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
        consolePane = new JEditorPane();
        consolePane.setEditable(false);
        JScrollPane consoleScrollPane = new JScrollPane(consolePane);
        consoleScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        consoleScrollPane.setMinimumSize(new Dimension(200, 200));
        consoleScrollPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Konsool"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                editorScrollPane,
                consoleScrollPane);
        
        splitPane.setOneTouchExpandable(true);
        splitPane.setResizeWeight(0.9);
        add(menuBar, BorderLayout.NORTH);
        add(splitPane);
	}
	
	private JMenuBar getMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new BorderLayout());
		JButton button = new JButton("Kompileeri");
		JMenu menu = new JMenu("Fail");
		JMenuItem menuItem3 = new JMenuItem("Uus fail");
		JMenuItem menuItem2 = new JMenuItem("Salvesta fail");
		JMenuItem menuItem = new JMenuItem("Ava fail");
		menu.add(menuItem);
		menu.add(menuItem2);
		menu.add(menuItem3);
		menuItem.addActionListener(buttonListener());
		menuItem2.addActionListener(buttonListener());
		menuItem3.addActionListener(buttonListener());
		button.addActionListener(buttonListener());
		menuBar.add(menu, BorderLayout.WEST);
		menuBar.add(button, BorderLayout.EAST);
		return menuBar;
	}
	
	private ActionListener buttonListener(){
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String operation = e.getActionCommand();
				if(operation.equalsIgnoreCase("kompileeri")){
					try{
						try{
							savedFile.exists();
						}catch(NullPointerException ex){
							savedFile = new File(saveToFile());
						}					
					String className = savedFile.getName().replace(".ekp", "");
					File dir = savedFile.getAbsoluteFile().getParentFile();
					checkIfBinExsists(className, dir);
					AKTKc.createClassFile(editorPane.getText(), className, dir);
					AKTKc.runClass();
					}catch(Exception ex){
						ex.printStackTrace();
						consolePane.setText("Ei suutnud kompileerida");
					}
				}else if(operation.equalsIgnoreCase("uus fail")){
					savedFile = null;
					editorPane.setText("");
				}else if(operation.equalsIgnoreCase("salvesta fail")){
					saveToFile();
				}else if(operation.equalsIgnoreCase("ava fail")){
					openNewFile();
				}
			}
		};
		
	}
	
	private void openNewFile(){
		JFileChooser c = new JFileChooser();
		int rVal = c.showOpenDialog(this);
		if(rVal==JFileChooser.APPROVE_OPTION){
			savedFile = c.getSelectedFile();
			try{
				editorPane.setPage(savedFile.toURI().toURL());
			}catch(Exception e){
				consolePane.setText("Ei suutnud faili sisse lugeda.");
			}
		}
	}
	
	private String saveToFile(){
		JFileChooser c = new JFileChooser();
		int rVal = c.showSaveDialog(this);
		if(rVal==JFileChooser.APPROVE_OPTION){
			String filePath = c.getSelectedFile().getPath()+".ekp";
			try{
				FileWriter fw = new FileWriter(filePath);
				savedFile = new File(filePath);
				fw.write(editorPane.getText());
				fw.close();
			}catch(Exception e){
				consolePane.setText("Ei suutnud faili salvestada");
			}
			return filePath;
		}
		return null;
	}
	
	private void checkIfBinExsists(String className, File dir){
		File classFile = new File(dir.getPath()+"/bin");
		if(!classFile.exists()){classFile.mkdir();}
	}
}
