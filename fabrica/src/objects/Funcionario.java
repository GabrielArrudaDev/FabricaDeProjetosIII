/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

/**
 *
 * @author gabri
 */
public class Funcionario {
    String email;
    String senha;
    String senhaDois;

    public void setSenhaDois(String senhaDois) {
        this.senhaDois = senhaDois;
    }

    public String getSenhaDois() {
        return senhaDois;
    }

    public Funcionario(String email, String senha, String senhaDois) {
        this.email = email;
        this.senha = senha;
        this.senhaDois = senhaDois;
    }
    

    public Funcionario(String email, String senha) {
        this.email = email;
        this.senha = senha;
        
    }

    public Funcionario() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}