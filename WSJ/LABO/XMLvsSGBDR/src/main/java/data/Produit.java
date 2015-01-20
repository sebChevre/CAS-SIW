package data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by seb on 10.09.14.
 */
@Entity
public class Produit {
    private int prodId;
    private String prodDesc;
    private BigDecimal prodPrix;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "prod_id", nullable = false, insertable = true, updatable = true)
    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    @Basic
    @Column(name = "prod_desc", nullable = true, insertable = true, updatable = true, length = -1)
    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    @Basic
    @Column(name = "prod_prix", nullable = true, insertable = true, updatable = true, precision = 5)
    public BigDecimal getProdPrix() {
        return prodPrix;
    }

    public void setProdPrix(BigDecimal prodPrix) {
        this.prodPrix = prodPrix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produit produit = (Produit) o;

        if (prodId != produit.prodId) return false;
        if (prodDesc != null ? !prodDesc.equals(produit.prodDesc) : produit.prodDesc != null) return false;
        if (prodPrix != null ? !prodPrix.equals(produit.prodPrix) : produit.prodPrix != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prodId;
        result = 31 * result + (prodDesc != null ? prodDesc.hashCode() : 0);
        result = 31 * result + (prodPrix != null ? prodPrix.hashCode() : 0);
        return result;
    }
}
