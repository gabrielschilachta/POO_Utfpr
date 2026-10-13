package gui;

import factory.PessoaFactory;
import factory.PessoaFactory.TipoPessoa;
import Model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtividadeEmSala1 extends JFrame {
    private JTextArea txtExibicao;

    public AtividadeEmSala1() {
        super("Sistema de Cadastro Universitário - GUI com Padrões de Projeto");
        configurarJanela();
    }

    private void configurarJanela() {
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLayout(new BorderLayout(10, 10));
           JPanel panelHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel lblTitulo = new JLabel("Gestão Acadêmica - " +
        Universidade.getInstance().getNomeUniversidade());
            lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
            panelHeader.add(lblTitulo);
            add(panelHeader, BorderLayout.NORTH);
            txtExibicao = new JTextArea(12, 55);
            txtExibicao.setEditable(false);
            txtExibicao.setFont(new Font("Monospaced", Font.PLAIN, 12));
            JScrollPane scrollPane = new JScrollPane(txtExibicao);
            scrollPane.setBorder(BorderFactory.createTitledBorder("Pessoas Cadastradas"));
            add(scrollPane, BorderLayout.CENTER);

            JPanel panelBotoes = new JPanel(new GridLayout(1, 3, 10, 10));
            panelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
            JButton btnCadastrarProfessor = new JButton("Cadastrar Professor");
            JButton btnAtualizarLista = new JButton("Atualizar Lista");

            panelBotoes.add(btnCadastrarAluno);
            panelBotoes.add(btnCadastrarProfessor);
            panelBotoes.add(btnAtualizarLista);

            add(panelBotoes, BorderLayout.SOUTH);

            btnCadastrarAluno.addActionListener(e -> abrirFormulario(TipoPessoa.ALUNO));

                btnCadastrarProfessor.addActionListener(e -> abrirFormulario(TipoPessoa.PROFESSOR));

                btnAtualizarLista.addActionListener(e -> atualizarListaCadastrados());

                pack();
                setLocationRelativeTo(null);
                atualizarListaCadastrados(); }

    private void abrirFormulario(TipoPessoa tipo) {
        FormularioCadastroDialog dialog = new FormularioCadastroDialog(this, tipo);
        dialog.setVisible(true);
        atualizarListaCadastrados();
    }

    private void atualizarListaCadastrados() {
        StringBuilder sb = new StringBuilder();
        Universidade uni = Universidade.getInstance();
        sb.append("=== ALUNOS MATRICULADOS ===\\n");
        if (uni.getListaAlunos().isEmpty()) {
            sb.append("Nenhum aluno cadastrado.\\n");
        } else {
            for (Aluno a : uni.getListaAlunos()) {
                sb.append("• ").append(a.apresentacao()).append("\\n");
            }
        }
        sb.append("\\n=== PROFESSORES CADASTRADOS ===\\n");
        if (uni.getListaProfessores().isEmpty()) {
            sb.append("Nenhum professor cadastrado.\\n");
        } else {
            for (Professor p : uni.getListaProfessores()) {
                sb.append("• ").append(p.apresentacao()).append("\\n");
            }
        }
        txtExibicao.setText(sb.toString());
    }

    private class FormularioCadastroDialog extends JDialog {
        private JTextField txtNome;
        private JTextField txtCpf;
        private JTextField txtCampoEspecifico;
        private TipoPessoa tipoPessoa;

        public FormularioCadastroDialog(Frame owner, TipoPessoa tipo) {
            super(owner, "Cadastrar " + (tipo == TipoPessoa.ALUNO ? "Aluno" : "Professor"), true);
            this.tipoPessoa = tipo;
            initUI();
        }

        private void initUI() {
            setLayout(new BorderLayout(10, 10));
            JPanel panelForm = new JPanel(new GridBagLayout());
            panelForm.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 0;
            panelForm.add(new JLabel("Nome Completo:"), gbc);
            gbc.gridx = 1;
            gbc.weightx = 1.0;
            txtNome = new JTextField(20);
            panelForm.add(txtNome, gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 0.0;
            panelForm.add(new JLabel("CPF (11 dígitos):"), gbc);
            gbc.gridx = 1;
            gbc.weightx = 1.0;
            txtCpf = new JTextField(20);
            panelForm.add(txtCpf, gbc);
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.weightx = 0.0;
            JLabel lblEspecifico = new JLabel(tipoPessoa == TipoPessoa.ALUNO ? "Matrícula:" : "Salário (R$):");
            panelForm.add(lblEspecifico, gbc);
            gbc.gridx = 1; gbc.weightx = 1.0;
            txtCampoEspecifico = new JTextField(20);
            panelForm.add(txtCampoEspecifico, gbc);
            add(panelForm, BorderLayout.CENTER);
            JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton btnSalvar = new JButton("Salvar Cadastro");
            JButton btnCancelar = new JButton("Cancelar");
            panelButtons.add(btnSalvar);
            panelButtons.add(btnCancelar);
            add(panelButtons, BorderLayout.SOUTH);
            btnSalvar.addActionListener(new ActionListener() {
                 @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                         Pessoa pessoaCriada = PessoaFactory.criarPessoa( tipoPessoa, txtNome.getText(), txtCpf.getText(), txtCampoEspecifico.getText() );
                        Universidade uni = Universidade.getInstance();
                        if (pessoaCriada instanceof Aluno) {
                            uni.matricularAluno((Aluno) pessoaCriada);
                         } else if (pessoaCriada instanceof Professor) {
                             uni.cadastrarProfessor((Professor) pessoaCriada);
                            }
                             JOptionPane.showMessageDialog( FormularioCadastroDialog.this, (tipoPessoa == TipoPessoa.ALUNO ? "Aluno" : "Professor") + " cadastrado(a) com sucesso!", "Sucesso", 
                             JOptionPane.INFORMATION_MESSAGE );
                              dispose();
                             }
                              catch (DadosInvalidosException ex) { 
                                JOptionPane.showMessageDialog( FormularioCadastroDialog.this, ex.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE );
                             }
                             }
                             }
                            ); btnCancelar.addActionListener(e -> dispose()); pack(); setLocationRelativeTo(getOwner()); }
    }

    public static void main(String[] args) { SwingUtilities.invokeLater(() -> { AtividadeEmSala1 janela = new AtividadeEmSala1(); janela.setVisible(true); }); }
}