package ifma.edu.imobiliaria.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Locacao {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private long id_imovel;
    @NotNull
    private long id_inquilino;

    private long ativo;

    @Length(max = 10)
    private String data_fim;
    @Length(max = 10)
    private String data_inicio;
    @Length(max = 10)
    private String data_vencimento;

    private Double perc_multa;
    private Double valor_aluguel;

    @Length(max = 255)
    private String obs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_imovel() {
        return id_imovel;
    }

    public void setId_imovel(long id_imovel) {
        this.id_imovel = id_imovel;
    }

    public long getId_inquilino() {
        return id_inquilino;
    }

    public void setId_inquilino(long id_inquilino) {
        this.id_inquilino = id_inquilino;
    }

    public long getAtivo() {
        return ativo;
    }

    public void setAtivo(long ativo) {
        this.ativo = ativo;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public Double getPerc_multa() {
        return perc_multa;
    }

    public void setPerc_multa(Double perc_multa) {
        this.perc_multa = perc_multa;
    }

    public Double getValor_aluguel() {
        return valor_aluguel;
    }

    public void setValor_aluguel(Double valor_aluguel) {
        this.valor_aluguel = valor_aluguel;
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
        Locacao locacao = (Locacao) o;
        return Objects.equals(id, locacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "id=" + id +
                ", dtini ='" + data_inicio + '\'' +
                ", dtfim='" + data_fim + '\'' +
                ", imovel ='" + id_imovel + '\'' +
                ", inquilino ='" + id_inquilino + '\'' +
                '}';
    }
}
