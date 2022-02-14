package ifma.edu.imobiliaria.model;

import org.hibernate.validator.constraints.Length;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Aluguel {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer id_locacao;

    @Length(max = 50) @NotNull
    private String dt_vencimento;


    private Double valor_pago;

    @Length(max = 255)
    private String obs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_locacao() {
        return id_locacao;
    }

    public void setId_locacao(Integer id_locacao) {
        this.id_locacao = id_locacao;
    }

    public String getDt_vencimento() {
        return dt_vencimento;
    }

    public void setDt_vencimento(String dt_vencimento) {
        this.dt_vencimento = dt_vencimento;
    }

    public Double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(Double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluguel aluguel = (Aluguel) o;
        return Objects.equals(id, aluguel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "id=" + id +
                ", valor ='" + valor_pago + '\'' +
                ", dt vencimento='" + dt_vencimento + '\'' +
                '}';
    }
}
