package data;

import javax.persistence.*;

/**
 * Created by seb on 10.09.14.
 */
@Entity
public class Client {
    private int clieId;
    private String clieNom;
    private String cliePrenom;
    private String clieRue;
    private String clieLocalite;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "clie_id", nullable = false, insertable = true, updatable = true)
    public int getClieId() {
        return clieId;
    }

    public void setClieId(int clieId) {
        this.clieId = clieId;
    }

    @Basic
    @Column(name = "clie_nom", nullable = true, insertable = true, updatable = true, length = -1)
    public String getClieNom() {
        return clieNom;
    }

    public void setClieNom(String clieNom) {
        this.clieNom = clieNom;
    }

    @Basic
    @Column(name = "clie_prenom", nullable = true, insertable = true, updatable = true, length = -1)
    public String getCliePrenom() {
        return cliePrenom;
    }

    public void setCliePrenom(String cliePrenom) {
        this.cliePrenom = cliePrenom;
    }

    @Basic
    @Column(name = "clie_rue", nullable = true, insertable = true, updatable = true, length = -1)
    public String getClieRue() {
        return clieRue;
    }

    public void setClieRue(String clieRue) {
        this.clieRue = clieRue;
    }

    @Basic
    @Column(name = "clie_localite", nullable = true, insertable = true, updatable = true, length = -1)
    public String getClieLocalite() {
        return clieLocalite;
    }

    public void setClieLocalite(String clieLocalite) {
        this.clieLocalite = clieLocalite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (clieId != client.clieId) return false;
        if (clieLocalite != null ? !clieLocalite.equals(client.clieLocalite) : client.clieLocalite != null)
            return false;
        if (clieNom != null ? !clieNom.equals(client.clieNom) : client.clieNom != null) return false;
        if (cliePrenom != null ? !cliePrenom.equals(client.cliePrenom) : client.cliePrenom != null) return false;
        if (clieRue != null ? !clieRue.equals(client.clieRue) : client.clieRue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clieId;
        result = 31 * result + (clieNom != null ? clieNom.hashCode() : 0);
        result = 31 * result + (cliePrenom != null ? cliePrenom.hashCode() : 0);
        result = 31 * result + (clieRue != null ? clieRue.hashCode() : 0);
        result = 31 * result + (clieLocalite != null ? clieLocalite.hashCode() : 0);
        return result;
    }
}
