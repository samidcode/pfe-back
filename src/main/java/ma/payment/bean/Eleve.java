package ma.payment.bean;

import javax.persistence.*;

@Entity
public class Eleve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idMassar;
    private String nom;
    private String prenom;
    private String dateNaissance;

    @Lob
    private byte[] image;

    @ManyToOne
    private Classe classe;

    @ManyToOne
    private Payeur payeur;

    public Eleve(Integer id) {
        this.id = id;
    }

    public Eleve() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMassar() {
        return idMassar;
    }

    public void setIdMassar(Integer idMassar) {
        this.idMassar = idMassar;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Payeur getPayeur() {
        return payeur;
    }

    public void setPayeur(Payeur payeur) {
        this.payeur = payeur;
    }
}
