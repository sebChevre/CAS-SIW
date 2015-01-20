package data;

import javax.persistence.*;

/**
 * Created by seb on 10.09.14.
 */
@Entity
@Table(name = "ligne_commande", schema = "", catalog = "shop")
public class LigneCommande {
    private int lncmId;
    private int commandeCmdeId;
    private int produitProdId;
    private Integer lncmProduitNombre;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "lncm_id", nullable = false, insertable = true, updatable = true)
    public int getLncmId() {
        return lncmId;
    }

    public void setLncmId(int lncmId) {
        this.lncmId = lncmId;
    }

    @Basic
    @Column(name = "commande_cmde_id", nullable = false, insertable = true, updatable = true)
    public int getCommandeCmdeId() {
        return commandeCmdeId;
    }

    public void setCommandeCmdeId(int commandeCmdeId) {
        this.commandeCmdeId = commandeCmdeId;
    }

    @Basic
    @Column(name = "produit_prod_id", nullable = false, insertable = true, updatable = true)
    public int getProduitProdId() {
        return produitProdId;
    }

    public void setProduitProdId(int produitProdId) {
        this.produitProdId = produitProdId;
    }

    @Basic
    @Column(name = "lncm_produit_nombre", nullable = true, insertable = true, updatable = true)
    public Integer getLncmProduitNombre() {
        return lncmProduitNombre;
    }

    public void setLncmProduitNombre(Integer lncmProduitNombre) {
        this.lncmProduitNombre = lncmProduitNombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LigneCommande that = (LigneCommande) o;

        if (commandeCmdeId != that.commandeCmdeId) return false;
        if (lncmId != that.lncmId) return false;
        if (produitProdId != that.produitProdId) return false;
        if (lncmProduitNombre != null ? !lncmProduitNombre.equals(that.lncmProduitNombre) : that.lncmProduitNombre != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lncmId;
        result = 31 * result + commandeCmdeId;
        result = 31 * result + produitProdId;
        result = 31 * result + (lncmProduitNombre != null ? lncmProduitNombre.hashCode() : 0);
        return result;
    }
}
