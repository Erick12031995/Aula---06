package jframe;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Agenda;
import service.AgendaService;

public class AgendaJF extends JFrame implements ActionListener{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nome, telefone, endereco, email;
	private JTextField txtNome, txtTelefone, txtEndereco, txtEmail;
	private JButton inserir, excluir, editar, pesquisar, sair, limpar;
   
   public AgendaJF(Connection conn){
      super("Agenda");

      Container caixa = getContentPane();
      
      nome = new JLabel("Nome: ");
      nome.setBounds(150,75,45,35);
      
      telefone = new JLabel("Telefone: ");
      telefone.setBounds(150,125,80,35);
      
      endereco = new JLabel("Endereço: ");
      endereco.setBounds(150, 175, 80, 35);
      
      email = new JLabel("Email: ");
      email.setBounds(150, 225, 80, 35);
      
      txtNome = new JTextField("");
      txtNome.setBounds(230,70,320,35);
      
      txtTelefone = new JTextField("");
      txtTelefone.setBounds(230,120,320,35);
      
      txtEndereco = new JTextField("");
      txtEndereco.setBounds(230, 170, 320, 35);
      
      txtEmail = new JTextField("");
      txtEmail.setBounds(230, 220, 320, 35);
      
      inserir = new JButton("Inserir");
      inserir.setBounds(0,0,175,35);
      inserir.setBackground(new Color(217, 217, 217));
      
      excluir = new JButton("Excluir");
      excluir.setBounds(175,0,175,35);
      excluir.setBackground(new Color(217, 217, 217));
      
      editar = new JButton("Editar");
      editar.setBounds(350,0,175,35);
      editar.setBackground(new Color(217, 217, 217));
      
      pesquisar = new JButton("Pesquisar");
      pesquisar.setBounds(515,0,175,35);
      pesquisar.setBackground(new Color(217, 217, 217));
      
      sair = new JButton("Sair");
      sair.setBounds(450,310,175,35);
      sair.setBackground(new Color(217, 217, 217));
      
      limpar = new JButton("Limpar");
      limpar.setBounds(120, 310, 175, 35);
      limpar.setBackground(new Color(217,217,217));
      
      //Adicionando 
      caixa.add(nome);
      caixa.add(telefone);
      caixa.add(txtNome);
      caixa.add(txtTelefone);
      caixa.add(excluir);
      caixa.add(pesquisar);
      caixa.add(inserir);
      caixa.add(editar);
      caixa.add(sair);
      caixa.add(email);
      caixa.add(endereco);
      caixa.add(txtEmail);
      caixa.add(txtEndereco);
      caixa.add(limpar);
      
      //ActionListener
      sair.addActionListener(this);
      excluir.addActionListener(this);
      pesquisar.addActionListener(this);
      inserir.addActionListener(this);
      editar.addActionListener(this);
      limpar.addActionListener(this);
      //Tela
      setSize(700,400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(null);
      setResizable(false);
      setLocationRelativeTo(null);
      setVisible(true);
   }
   public void actionPerformed(ActionEvent e){
	   AgendaService agendaService = new AgendaService();
	   if(e.getSource()==inserir){
	         if(txtNome.getText().trim().equals("") && txtTelefone.getText().trim().equals("") && txtEndereco.getText().trim().equals("") && txtEmail.getText().trim().equals("")){
	            JOptionPane.showMessageDialog(this, "Por favor professor preencha todos os campos!");
	         }else{
	             Agenda agenda = new Agenda(txtNome.getText(),txtTelefone.getText(),txtEndereco.getText(), txtEmail.getText());
	             
	             agendaService.inserir(agenda);
	             txtNome.setText("");
	             txtTelefone.setText("");
	             txtEndereco.setText("");
	             txtEmail.setText("");
				 JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
	         }
	         }
	   if(e.getSource()==sair){
         System.exit(0);
      }
         if(e.getSource()==excluir){
        	int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID"));
            Agenda agenda= new Agenda(id);
            agendaService.excluir(agenda.getId());
         
            txtNome.setText(agenda.getNome());
            txtTelefone.setText(agenda.getTelefone());
            txtEndereco.setText(agenda.getEndereco());
            txtEmail.setText(agenda.getEmail());
         }
         else if(e.getSource()==pesquisar){
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID"));
            Agenda agenda = new Agenda(id);
            agendaService.pesquisar(id);
            
            txtNome.setText(agenda.getNome());
            txtTelefone.setText(agenda.getTelefone());
            txtEndereco.setText(agenda.getEndereco());
            txtEmail.setText(agenda.getEmail());
            
         }else if(e.getSource()==editar){
            Agenda agenda = new Agenda(txtNome.getText(), txtTelefone.getText(), txtEndereco.getText(), txtEmail.getText());
            agendaService.atualizar(agenda);
            JOptionPane.showMessageDialog(null, "Alterado!");
         } else if(e.getSource()==limpar){
            txtNome.setText("");
            txtTelefone.setText("");
            txtEndereco.setText("");
            txtEmail.setText("");
         }
         else {
      }
   }
   
}