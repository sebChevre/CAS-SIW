package data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by seb on 10.09.14.
 */
@Entity
public class Commande {
    private int cmdeId;
    private Timestamp cmdeDate;
    private int clientClieId;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "cmde_id", nullable = false, insertable = true, updatable = true)
    public int getCmdeId() {
        return cmdeId;
    }

    public void setCmdeId(int cmdeId) {
        this.cmdeId = cmdeId;
    }

    @Basic
    @Column(name = "cmde_date", nullable = true, insertable = true, updatable = true)
    public Timestamp getCmdeDate() {
        return cmdeDate;
    }

    public void setCmdeDate(Timestamp cmdeDate) {
        this.cmdeDate = cmdeDate;
    }

    @Basic
    @Column(name = "client_clie_id", nullable = false, insertable = true, updatable = true)
    public int getClientClieId() {
        return clientClieId;
    }

    public void setClientClieId(int clientClieId) {
        this.clientClieId = clientClieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commande commande = (Commande) o;

        if (clientClieId != commande.clientClieId) return false;
        if (cmdeId != commande.cmdeId) return false;
        if (cmdeDate != null ? !cmdeDate.equals(commande.cmdeDate) : commande.cmdeDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cmdeId;
        result = 31 * result + (cmdeDate != null ? cmdeDate.hashCode() : 0);
        result = 31 * result + clientClieId;
        return result;
    }
}
