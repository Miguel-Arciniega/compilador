/*
 * The MIT License
 *
 * Copyright 2021 Deimos.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.deimos.compilador.view;

import com.deimos.compilador.services.analysis.AnalysisService;
import com.deimos.compilador.utils.FileHandler;
import com.deimos.compilador.services.theme.LookAndFeelService;
import com.deimos.compilador.utils.editor.TextLineNumber;
import com.deimos.compilador.model.errors.CompilationErrors;
import com.deimos.compilador.model.variables.Variables;
import com.deimos.compilador.services.ErrorHandlerService;
import com.deimos.compilador.utils.editor.CodeEditorUtils;
import com.deimos.compilador.utils.editor.FontUitls;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ImageIcon;
import com.deimos.compilador.utils.EditorColors;

import static com.deimos.compilador.utils.StringConstants.PROJECT_CONFIG;
import static com.deimos.compilador.utils.StringConstants.PROJECT_FOLDER;
import static com.deimos.compilador.utils.StringConstants.THEME_FILE;
import static com.deimos.compilador.utils.StringConstants.USER_DOCUMENTS_FOLDER;
import static com.deimos.compilador.utils.StringConstants.WINDOW_INITIAL_TITLE;

import static com.deimos.compilador.services.theme.LookAndFeelService.MATERIAL_DARK;
import static com.deimos.compilador.services.theme.LookAndFeelService.MATERIAL_LIGHT;
import static com.deimos.compilador.services.theme.LookAndFeelService.MONOKAI;
import static com.deimos.compilador.services.theme.LookAndFeelService.MOONLIGHT;
import static com.deimos.compilador.services.theme.LookAndFeelService.ONE_DARK;
import com.deimos.compilador.services.paint.PaintService;
import javax.swing.JTextPane;
import lombok.extern.java.Log;

/**
 *
 * Compiler Application to Code and Compile Arduino Programs
 * 
 * @author Deimos
 *
 */
@Log
public class CompiladorUI extends javax.swing.JFrame {
        
    private final FileHandler lookAndFeelFile;
    
    /**
     * 
     * Crea el form para el Compiler
     * Inicializa todos los componentes, objetos y atributos necesarios
     * 
     */
    @SuppressWarnings({"OverridableMethodCallInConstructor", "ResultOfObjectAllocationIgnored"})
    public CompiladorUI() {
       
        /**
        * Inicializa los errores
        * Inicializa los components 
        * Inicializa el CodeEditor
        */
        log.info("Inicializando componentes\n");
        initComponents();    
        initCodeEditor();
        
        /**
         * Crea un instancia del manejador de archivos (FileHandler)
         * El manejador crea la carpeta Compiler/Config y el archivo
         * lookandfeel.txt si no existen
         */
        log.info("Creando archivos necesarios\n");
        this.lookAndFeelFile = new FileHandler(THEME_FILE,
                USER_DOCUMENTS_FOLDER.concat(PROJECT_FOLDER) + PROJECT_CONFIG);
        
        /**
        * Centra la ventana
        * Crea una instancia del manejador de temas (LookAndFeelHandler)
        *   y establece el tema de la UI
        * Crea unna instancia del analizador (Analyzer)
        */
        this.setLocationRelativeTo(null);
        new LookAndFeelService(this, this.lookAndFeelFile, textPane_editor).setLookAndFeel();
        this.setTitle(WINDOW_INITIAL_TITLE);
        
        // Agrega los números de linea al editor   
        TextLineNumber textLineNumberEditor = new TextLineNumber(textPane_editor);
        TextLineNumber textLineNumberConsole = new TextLineNumber(textPane_console);
        textLineNumberEditor.setUpdateFont(true);
        textLineNumberConsole.setUpdateFont(true);
        scrollPane_editor.setRowHeaderView(textLineNumberEditor);
        scrollPane_console.setRowHeaderView(textLineNumberConsole);
        
        // Lee el archivo de configs y define el estado inicial de los radioMenuButton
        log.info("Aplicando tema a la UI\n");
        radioMenu_Monokai.setSelected(lookAndFeelFile.read().equals("MONOKAI"));
        radioMenu_Monokai.setEnabled(!lookAndFeelFile.read().equals("MONOKAI"));
        radioMenu_One_Dark.setSelected(lookAndFeelFile.read().equals("ONE DARK"));
        radioMenu_One_Dark.setEnabled(!lookAndFeelFile.read().equals("ONE DARK"));
        radioMenu_Material_Dark.setSelected(lookAndFeelFile.read().equals("MATERIAL DARK"));
        radioMenu_Material_Dark.setEnabled(!lookAndFeelFile.read().equals("MATERIAL DARK"));
        radioMenu_Material_Light.setSelected(lookAndFeelFile.read().equals("MATERIAL LIGHT"));
        radioMenu_Material_Light.setEnabled(!lookAndFeelFile.read().equals("MATERIAL LIGHT"));
        radioMenu_Moonlight.setSelected(lookAndFeelFile.read().equals("MOONLIGHT"));
        radioMenu_Moonlight.setEnabled(!lookAndFeelFile.read().equals("MOONLIGHT"));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        panel_contenedor = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        scroll_panel_tree = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        splitPane_main = new javax.swing.JSplitPane();
        scrollPane_editor = new javax.swing.JScrollPane();
        textPane_editor = new javax.swing.JTextPane()  {
            @Override
            public boolean getScrollableTracksViewportWidth() {
                return getUI().getPreferredSize(this).width
                <= getParent().getSize().width;
            }
        };
        scrollPane_console = new javax.swing.JScrollPane();
        textPane_console = new javax.swing.JTextPane();
        pane_toolbar = new javax.swing.JPanel();
        toolbar_buttons = new javax.swing.JToolBar();
        filler29 = new javax.swing.Box.Filler(new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 32767));
        filler30 = new javax.swing.Box.Filler(new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 0), new java.awt.Dimension(10, 32767));
        btn_new = new javax.swing.JButton();
        btn_open = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_save_as = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        btn_cut = new javax.swing.JButton();
        btn_copy = new javax.swing.JButton();
        btn_paste = new javax.swing.JButton();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        btn_undo = new javax.swing.JButton();
        btn_redo = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        filler22 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        btn_compilar = new javax.swing.JButton();
        menuBar_principal = new javax.swing.JMenuBar();
        menu_file = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menu_edit = new javax.swing.JMenu();
        menuItem_cut = new javax.swing.JMenuItem();
        menuItem_copy = new javax.swing.JMenuItem();
        menuItem_paste = new javax.swing.JMenuItem();
        menu_view = new javax.swing.JMenu();
        menu_toolbar = new javax.swing.JCheckBoxMenuItem();
        menu_run = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menu_window = new javax.swing.JMenu();
        menu_themes = new javax.swing.JMenu();
        radioMenu_Material_Dark = new javax.swing.JRadioButtonMenuItem();
        radioMenu_Material_Light = new javax.swing.JRadioButtonMenuItem();
        radioMenu_One_Dark = new javax.swing.JRadioButtonMenuItem();
        radioMenu_Monokai = new javax.swing.JRadioButtonMenuItem();
        radioMenu_Moonlight = new javax.swing.JRadioButtonMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menu_change_font = new javax.swing.JMenuItem();
        IncFont = new javax.swing.JMenuItem();
        decFont = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SHL - New File.shl");
        setBackground(new java.awt.Color(102, 102, 102));
        setIconImage(new ImageIcon("src/main/java/resources/icon.png").getImage());

        jSplitPane1.setDividerLocation(240);
        jSplitPane1.setDividerSize(20);

        scroll_panel_tree.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTree1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Workspace");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Nuevo.scl");
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setFocusable(false);
        jTree1.setMaximumSize(new java.awt.Dimension(104, 120));
        jTree1.setMinimumSize(new java.awt.Dimension(20, 120));
        jTree1.setShowsRootHandles(true);
        scroll_panel_tree.setViewportView(jTree1);

        jSplitPane1.setLeftComponent(scroll_panel_tree);

        splitPane_main.setDividerLocation(425);
        splitPane_main.setDividerSize(20);
        splitPane_main.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        splitPane_main.setResizeWeight(0.7);
        splitPane_main.setToolTipText("");

        scrollPane_editor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        scrollPane_editor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        scrollPane_editor.setFocusCycleRoot(true);

        textPane_editor.setBorder(null);
        textPane_editor.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        textPane_editor.setHighlighter(null);
        textPane_editor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textPane_editorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textPane_editorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textPane_editorKeyTyped(evt);
            }
        });
        scrollPane_editor.setViewportView(textPane_editor);

        splitPane_main.setTopComponent(scrollPane_editor);

        scrollPane_console.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        scrollPane_console.setForeground(new java.awt.Color(102, 102, 102));
        scrollPane_console.setFocusCycleRoot(true);

        textPane_console.setBorder(null);
        textPane_console.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        textPane_console.setToolTipText("");
        textPane_console.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textPane_console.setHighlighter(null);
        scrollPane_console.setViewportView(textPane_console);

        splitPane_main.setBottomComponent(scrollPane_console);

        jSplitPane1.setRightComponent(splitPane_main);

        javax.swing.GroupLayout panel_contenedorLayout = new javax.swing.GroupLayout(panel_contenedor);
        panel_contenedor.setLayout(panel_contenedorLayout);
        panel_contenedorLayout.setHorizontalGroup(
            panel_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contenedorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSplitPane1)
                .addGap(20, 20, 20))
        );
        panel_contenedorLayout.setVerticalGroup(
            panel_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );

        toolbar_buttons.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        toolbar_buttons.setFloatable(false);
        toolbar_buttons.setRollover(true);
        toolbar_buttons.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        toolbar_buttons.add(filler29);
        toolbar_buttons.add(filler30);

        btn_new.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btn_new.setIcon(new javax.swing.ImageIcon("C:\\Users\\arcin\\Documents\\NetBeansProjects\\CompiladorJava\\src\\main\\java\\resources\\projectAdd.png")); // NOI18N
        btn_new.setToolTipText("Nuevo");
        btn_new.setFocusable(false);
        btn_new.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_new.setMaximumSize(new java.awt.Dimension(48, 48));
        btn_new.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_new.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });
        toolbar_buttons.add(btn_new);

        btn_open.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btn_open.setIcon(new javax.swing.ImageIcon("C:\\Users\\arcin\\Documents\\NetBeansProjects\\CompiladorJava\\src\\main\\java\\resources\\abrir.png")); // NOI18N
        btn_open.setToolTipText("Abrir");
        btn_open.setFocusable(false);
        btn_open.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_open.setMaximumSize(new java.awt.Dimension(48, 48));
        btn_open.setMinimumSize(new java.awt.Dimension(32, 32));
        btn_open.setPreferredSize(new java.awt.Dimension(32, 32));
        btn_open.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_open.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openActionPerformed(evt);
            }
        });
        toolbar_buttons.add(btn_open);

        btn_save.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btn_save.setIcon(new javax.swing.ImageIcon("C:\\Users\\arcin\\Documents\\NetBeansProjects\\CompiladorJava\\src\\main\\java\\resources\\save.png")); // NOI18N
        btn_save.setToolTipText("Guardar Como");
        btn_save.setFocusable(false);
        btn_save.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_save.setMaximumSize(new java.awt.Dimension(48, 48));
        btn_save.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_save.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        toolbar_buttons.add(btn_save);

        btn_save_as.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btn_save_as.setIcon(new javax.swing.ImageIcon("C:\\Users\\arcin\\Documents\\NetBeansProjects\\CompiladorJava\\src\\main\\java\\resources\\save-as.png")); // NOI18N
        btn_save_as.setToolTipText("Guardar");
        btn_save_as.setFocusable(false);
        btn_save_as.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_save_as.setMaximumSize(new java.awt.Dimension(48, 48));
        btn_save_as.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_save_as.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_save_as.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_save_asActionPerformed(evt);
            }
        });
        toolbar_buttons.add(btn_save_as);

        jSeparator13.setMaximumSize(new java.awt.Dimension(7, 100));
        jSeparator13.setMinimumSize(new java.awt.Dimension(0, 100));
        jSeparator13.setOpaque(true);
        jSeparator13.setPreferredSize(new java.awt.Dimension(20, 0));
        toolbar_buttons.add(jSeparator13);

        btn_cut.setIcon(new javax.swing.ImageIcon("C:\\Users\\arcin\\Documents\\NetBeansProjects\\CompiladorJava\\src\\main\\java\\resources\\tijeras.png")); // NOI18N
        btn_cut.setToolTipText("Cortar");
        btn_cut.setFocusable(false);
        btn_cut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cut.setMaximumSize(new java.awt.Dimension(48, 48));
        btn_cut.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_cut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cutActionPerformed(evt);
            }
        });
        toolbar_buttons.add(btn_cut);

        btn_copy.setIcon(new javax.swing.ImageIcon("C:\\Users\\arcin\\Documents\\NetBeansProjects\\CompiladorJava\\src\\main\\java\\resources\\Copiar.png")); // NOI18N
        btn_copy.setToolTipText("Copiar");
        btn_copy.setFocusable(false);
        btn_copy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_copy.setMaximumSize(new java.awt.Dimension(48, 48));
        btn_copy.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_copy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_copyActionPerformed(evt);
            }
        });
        toolbar_buttons.add(btn_copy);

        btn_paste.setIcon(new javax.swing.ImageIcon("C:\\Users\\arcin\\Documents\\NetBeansProjects\\CompiladorJava\\src\\main\\java\\resources\\clipboard.png")); // NOI18N
        btn_paste.setToolTipText("Pegar");
        btn_paste.setFocusable(false);
        btn_paste.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_paste.setMaximumSize(new java.awt.Dimension(48, 48));
        btn_paste.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_paste.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pasteActionPerformed(evt);
            }
        });
        toolbar_buttons.add(btn_paste);
        toolbar_buttons.add(jSeparator14);

        btn_undo.setIcon(new javax.swing.ImageIcon("C:\\Users\\arcin\\Documents\\NetBeansProjects\\CompiladorJava\\src\\main\\java\\resources\\undo.png")); // NOI18N
        btn_undo.setToolTipText("Deshacer");
        btn_undo.setFocusable(false);
        btn_undo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_undo.setMaximumSize(new java.awt.Dimension(48, 48));
        btn_undo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_undo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar_buttons.add(btn_undo);

        btn_redo.setIcon(new javax.swing.ImageIcon("C:\\Users\\arcin\\Documents\\NetBeansProjects\\CompiladorJava\\src\\main\\java\\resources\\redo.png")); // NOI18N
        btn_redo.setToolTipText("Rehacer");
        btn_redo.setFocusable(false);
        btn_redo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_redo.setMaximumSize(new java.awt.Dimension(48, 48));
        btn_redo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_redo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_redoActionPerformed(evt);
            }
        });
        toolbar_buttons.add(btn_redo);
        toolbar_buttons.add(jSeparator15);
        toolbar_buttons.add(filler22);

        btn_compilar.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btn_compilar.setIcon(new javax.swing.ImageIcon("C:\\Users\\arcin\\Documents\\NetBeansProjects\\CompiladorJava\\src\\main\\java\\resources\\jugar.png")); // NOI18N
        btn_compilar.setToolTipText("Compilar");
        btn_compilar.setFocusable(false);
        btn_compilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_compilar.setMaximumSize(new java.awt.Dimension(48, 48));
        btn_compilar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_compilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_compilarActionPerformed(evt);
            }
        });
        toolbar_buttons.add(btn_compilar);

        javax.swing.GroupLayout pane_toolbarLayout = new javax.swing.GroupLayout(pane_toolbar);
        pane_toolbar.setLayout(pane_toolbarLayout);
        pane_toolbarLayout.setHorizontalGroup(
            pane_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_toolbarLayout.createSequentialGroup()
                .addComponent(toolbar_buttons, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pane_toolbarLayout.setVerticalGroup(
            pane_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbar_buttons, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        menuBar_principal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuBar_principal.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                menuBar_principalComponentHidden(evt);
            }
        });

        menu_file.setText("File");
        menu_file.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("New File");
        menu_file.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("OpenFile");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menu_file.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setText("Save File");
        menu_file.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("Save File As");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menu_file.add(jMenuItem5);

        menuBar_principal.add(menu_file);

        menu_edit.setText("Edit");
        menu_edit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menuItem_cut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItem_cut.setText("Cut");
        menuItem_cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_cutActionPerformed(evt);
            }
        });
        menu_edit.add(menuItem_cut);

        menuItem_copy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItem_copy.setText("Copy");
        menuItem_copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_copyActionPerformed(evt);
            }
        });
        menu_edit.add(menuItem_copy);

        menuItem_paste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItem_paste.setText("Paste");
        menuItem_paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_pasteActionPerformed(evt);
            }
        });
        menu_edit.add(menuItem_paste);

        menuBar_principal.add(menu_edit);

        menu_view.setText("View");
        menu_view.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menu_toolbar.setSelected(true);
        menu_toolbar.setText("Toolbar");
        menu_toolbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_toolbarActionPerformed(evt);
            }
        });
        menu_view.add(menu_toolbar);

        menuBar_principal.add(menu_view);

        menu_run.setText("Run");
        menu_run.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem1.setText("Run Project");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu_run.add(jMenuItem1);

        menuBar_principal.add(menu_run);

        menu_window.setText("Window");

        menu_themes.setText("Themes");

        radioMenu_Material_Dark.setText("Material Dark");
        radioMenu_Material_Dark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMenu_Material_DarkActionPerformed(evt);
            }
        });
        menu_themes.add(radioMenu_Material_Dark);

        radioMenu_Material_Light.setSelected(true);
        radioMenu_Material_Light.setText("Material Light");
        radioMenu_Material_Light.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMenu_Material_LightActionPerformed(evt);
            }
        });
        menu_themes.add(radioMenu_Material_Light);

        radioMenu_One_Dark.setText("One Dark");
        radioMenu_One_Dark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMenu_One_DarkActionPerformed(evt);
            }
        });
        menu_themes.add(radioMenu_One_Dark);

        radioMenu_Monokai.setText("Monokai");
        radioMenu_Monokai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMenu_MonokaiActionPerformed(evt);
            }
        });
        menu_themes.add(radioMenu_Monokai);

        radioMenu_Moonlight.setSelected(true);
        radioMenu_Moonlight.setText("Moonlight");
        radioMenu_Moonlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMenu_MoonlightActionPerformed(evt);
            }
        });
        menu_themes.add(radioMenu_Moonlight);

        menu_window.add(menu_themes);

        jMenu1.setText("Font");

        menu_change_font.setText("Change Font");
        menu_change_font.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_change_fontActionPerformed(evt);
            }
        });
        jMenu1.add(menu_change_font);

        IncFont.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_UP, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        IncFont.setText("Increase Font Size");
        IncFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncFontActionPerformed(evt);
            }
        });
        jMenu1.add(IncFont);

        decFont.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DOWN, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        decFont.setText("Decrease Font Size");
        decFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decFontActionPerformed(evt);
            }
        });
        jMenu1.add(decFont);

        menu_window.add(jMenu1);

        menuBar_principal.add(menu_window);

        setJMenuBar(menuBar_principal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane_toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pane_toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItem_cutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_cutActionPerformed
       textPane_editor.cut();
    }//GEN-LAST:event_menuItem_cutActionPerformed

    private void btn_cutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cutActionPerformed
       textPane_editor.cut();
    }//GEN-LAST:event_btn_cutActionPerformed

    private void menuItem_copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_copyActionPerformed
        textPane_editor.copy();
    }//GEN-LAST:event_menuItem_copyActionPerformed

    private void menuItem_pasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_pasteActionPerformed
        textPane_editor.paste();
    }//GEN-LAST:event_menuItem_pasteActionPerformed

    private void btn_copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_copyActionPerformed
        textPane_editor.copy();
    }//GEN-LAST:event_btn_copyActionPerformed

    private void btn_pasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pasteActionPerformed
        textPane_editor.paste();
    }//GEN-LAST:event_btn_pasteActionPerformed

    private void radioMenu_Material_DarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMenu_Material_DarkActionPerformed
        setTheme(MATERIAL_DARK, radioMenu_Material_Dark);
    }//GEN-LAST:event_radioMenu_Material_DarkActionPerformed

    private void radioMenu_Material_LightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMenu_Material_LightActionPerformed
        setTheme(MATERIAL_LIGHT, radioMenu_Material_Light);
    }//GEN-LAST:event_radioMenu_Material_LightActionPerformed

    private void radioMenu_One_DarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMenu_One_DarkActionPerformed
        setTheme(ONE_DARK, radioMenu_One_Dark);
    }//GEN-LAST:event_radioMenu_One_DarkActionPerformed

    private void radioMenu_MonokaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMenu_MonokaiActionPerformed
        setTheme(MONOKAI, radioMenu_Monokai);
    }//GEN-LAST:event_radioMenu_MonokaiActionPerformed

    private void radioMenu_MoonlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMenu_MoonlightActionPerformed
        setTheme(MOONLIGHT, radioMenu_Moonlight);
    }//GEN-LAST:event_radioMenu_MoonlightActionPerformed

    private void btn_compilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_compilarActionPerformed
        compile();
    }//GEN-LAST:event_btn_compilarActionPerformed

    private void textPane_editorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPane_editorKeyPressed
        PaintService.start(textPane_editor);
    }//GEN-LAST:event_textPane_editorKeyPressed

    private void textPane_editorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPane_editorKeyReleased
        PaintService.start(textPane_editor);
    }//GEN-LAST:event_textPane_editorKeyReleased

    private void btn_redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_redoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_redoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        compile();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
       CodeEditorUtils.actionNew();
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openActionPerformed
        CodeEditorUtils.actionOpen();
    }//GEN-LAST:event_btn_openActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        CodeEditorUtils.actionSave();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_save_asActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_save_asActionPerformed
        CodeEditorUtils.actionSaveAs();
    }//GEN-LAST:event_btn_save_asActionPerformed

    private void textPane_editorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPane_editorKeyTyped
        PaintService.start(textPane_editor);
        CodeEditorUtils.hasChanged = true;
    }//GEN-LAST:event_textPane_editorKeyTyped

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void IncFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncFontActionPerformed
        if (getFocusOwner() == textPane_editor){
            FontUitls.changeFontSize(FontUitls.INCREASE, textPane_editor);
        }
        if (getFocusOwner() == textPane_console){
            FontUitls.changeFontSize(FontUitls.INCREASE, textPane_console);
        }
    }//GEN-LAST:event_IncFontActionPerformed

    private void decFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decFontActionPerformed
        if (getFocusOwner() == textPane_editor){
            FontUitls.changeFontSize(FontUitls.DECREASE, textPane_editor);
        }
        if (getFocusOwner() == textPane_console){
            FontUitls.changeFontSize(FontUitls.DECREASE, textPane_console);
        }
    }//GEN-LAST:event_decFontActionPerformed

    private void menu_change_fontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_change_fontActionPerformed
        FontUitls.actionSelectFont(new JTextPane[]{textPane_editor, textPane_console}, this);
    }//GEN-LAST:event_menu_change_fontActionPerformed

    private void menu_toolbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_toolbarActionPerformed
        toolbar_buttons.setVisible(!toolbar_buttons.isVisible());
    }//GEN-LAST:event_menu_toolbarActionPerformed

    private void menuBar_principalComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_menuBar_principalComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_menuBar_principalComponentHidden
    
    /**
     * Inicia la compilación. Llama a los métodos de analisis, generación de código y al manejador de errores
     *
     * @return Generated File and Console Output 
     */
    private void compile(){
        
        log.info("Compilando\n");
        
        // Guarda el archivo
        CodeEditorUtils.actionSave();
        
        // Si el código no ha cambiado y el código está guardado,
        // se inicia la compilación
        if(CodeEditorUtils.hasChanged == false && CodeEditorUtils.currentFile != null){           
            
            // Se crea una instancia del manejador de errores
            ErrorHandlerService errorHandler = new ErrorHandlerService(new CompilationErrors());
            
            // Se obtinene el código del editor
            final String code = textPane_editor.getText();
            
            // Se crea una instancia del servicio para analisis
            AnalysisService analysisService = new AnalysisService(new Variables());
                
            // Se inicia el analisis
            analysisService.start(code);
            
            /** 
             *  Se construye la salida de consola
             *  Si hay errores se agregan los mensajes de error
             */
            StringBuilder output = errorHandler.start(code);

            /**  
            *   Si hay errores:
            *      La compilación falla y se imprimen los mensajes de error 
            *      correspondientes en consola
            * 
            *   Si no hay errores:
            *      Se completa la compilación y se imprime el mensaje de 
            *      compilación exitosa en consola
            */
            log.info("Imprimendo mensaje en consola\n");
            if(errorHandler.error()){
                textPane_console.setText(output.toString());
                textPane_console.setForeground(EditorColors.CONSOLE_ERROR);
            }else{
                textPane_console.setText(output.toString());
                textPane_console.setForeground(EditorColors.CONSOLE_SUCCESS);
            }
        }
    }
    
    /**
     * 
     * Define el estado de los radioMenuButtons para todos los temas
     * @param radioMenu 
     */
    private void radioMenuBehavior(JRadioButtonMenuItem radioMenu){
        radioMenu_Material_Dark.setSelected(false);
        radioMenu_Material_Dark.setEnabled(true);
        
        radioMenu_Material_Light.setSelected(false);
        radioMenu_Material_Light.setEnabled(true);
        
        radioMenu_One_Dark.setSelected(false);
        radioMenu_One_Dark.setEnabled(true);

        radioMenu_Monokai.setSelected(false);
        radioMenu_Monokai.setEnabled(true);    

        radioMenu_Moonlight.setSelected(false);
        radioMenu_Moonlight.setEnabled(true);    

        radioMenu.setEnabled(false);
        radioMenu.setSelected(true);
    }
    
    /**
     *
     * Establece el tema para la UI y maneja el comportamiento de los radioMenuButtons
     * 
     * @param theme
     * @param radioMenu 
     */
    private void setTheme(String theme, JRadioButtonMenuItem radioMenu){
        lookAndFeelFile.write(theme);
        new LookAndFeelService(this, this.lookAndFeelFile, textPane_editor).setLookAndFeel();
        radioMenuBehavior(radioMenu);
    }
    
    /**
     *
     * Inicializa los campos de CodeEditorUtils y
     * Pinta palabras
     * 
     */
    private void initCodeEditor(){
        CodeEditorUtils.jFrame = this;
        CodeEditorUtils.jTextPaneEditor = this.textPane_editor;
        CodeEditorUtils.jTextPaneConsole = this.textPane_console;
        PaintService.start(textPane_editor);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem IncFont;
    private javax.swing.JButton btn_compilar;
    private javax.swing.JButton btn_copy;
    private javax.swing.JButton btn_cut;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_open;
    private javax.swing.JButton btn_paste;
    private javax.swing.JButton btn_redo;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_save_as;
    private javax.swing.JButton btn_undo;
    private javax.swing.JMenuItem decFont;
    private javax.swing.Box.Filler filler22;
    private javax.swing.Box.Filler filler29;
    private javax.swing.Box.Filler filler30;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JMenuBar menuBar_principal;
    private javax.swing.JMenuItem menuItem_copy;
    private javax.swing.JMenuItem menuItem_cut;
    private javax.swing.JMenuItem menuItem_paste;
    private javax.swing.JMenuItem menu_change_font;
    private javax.swing.JMenu menu_edit;
    private javax.swing.JMenu menu_file;
    private javax.swing.JMenu menu_run;
    private javax.swing.JMenu menu_themes;
    private javax.swing.JCheckBoxMenuItem menu_toolbar;
    private javax.swing.JMenu menu_view;
    private javax.swing.JMenu menu_window;
    private javax.swing.JPanel pane_toolbar;
    private javax.swing.JPanel panel_contenedor;
    private javax.swing.JRadioButtonMenuItem radioMenu_Material_Dark;
    private javax.swing.JRadioButtonMenuItem radioMenu_Material_Light;
    private javax.swing.JRadioButtonMenuItem radioMenu_Monokai;
    private javax.swing.JRadioButtonMenuItem radioMenu_Moonlight;
    private javax.swing.JRadioButtonMenuItem radioMenu_One_Dark;
    private javax.swing.JScrollPane scrollPane_console;
    private javax.swing.JScrollPane scrollPane_editor;
    private javax.swing.JScrollPane scroll_panel_tree;
    private javax.swing.JSplitPane splitPane_main;
    private javax.swing.JTextPane textPane_console;
    private javax.swing.JTextPane textPane_editor;
    private javax.swing.JToolBar toolbar_buttons;
    // End of variables declaration//GEN-END:variables
}
