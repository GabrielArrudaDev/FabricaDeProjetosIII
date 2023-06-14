/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;



/**
 *
 * @author gabri
 */
public class AgendamentoAnimal {
    
    String Animal;
    String nomeAnimal;
    String nomeDono;
    String telefone;
    String kilos;
    String hora;
    String servico;
    String agenda;
    String cpf;
    int idDono;

    

    public AgendamentoAnimal() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public AgendamentoAnimal(int idDono,String Animal, String nomeAnimal, String nomeDono, String telefone, String kilos, String hora, String servico, String agenda, String cpf) {
        this.idDono = idDono;
        this.Animal = Animal;
        this.nomeAnimal = nomeAnimal;
        this.nomeDono = nomeDono;
        this.telefone = telefone;
        this.kilos = kilos;
        this.hora = hora;
        this.servico = servico;
        this.agenda = agenda;
        this.cpf = cpf;
    }

    public int getIdDono() {
        return idDono;
    }

    public void setIdDono(int idDono) {
        this.idDono = idDono;
    }

    public String getAnimal() {
        return Animal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getKilos() {
        return kilos;
    }

    public String getHora() {
        return hora;
    }

    public String getServico() {
        return servico;
    }

    public String getAgenda() {
        return agenda;
    }

    public String getCpf() {
        return cpf;
    }

    public void setAnimal(String Animal) {
        this.Animal = Animal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setKilos(String kilos) {
        this.kilos = kilos;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    
    
}
   