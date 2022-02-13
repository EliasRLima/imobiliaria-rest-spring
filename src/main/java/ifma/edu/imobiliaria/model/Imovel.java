package ifma.edu.imobiliaria.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Imovel {

    @Id
    @GeneratedValue
    private Integer id;

    @Length(max = 50)
    private String tipo_imovel;

    @Length(max = 255)
    private String endereco;

    @Length(max = 10)
    private String cep;

    private Integer dormitorios;
    private Integer banheiros;
    private Integer suites;
    private Integer metragem;
    private Double valor_aluguel_sug;
    private String obs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo_imovel() {
        return tipo_imovel;
    }

    public void setTipo_imovel(String tipo_imovel) {
        this.tipo_imovel = tipo_imovel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(Integer dormitorios) {
        this.dormitorios = dormitorios;
    }

    public Integer getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(Integer banheiros) {
        this.banheiros = banheiros;
    }

    public Integer getSuites() {
        return suites;
    }

    public void setSuites(Integer suites) {
        this.suites = suites;
    }

    public Integer getMetragem() {
        return metragem;
    }

    public void setMetragem(Integer metragem) {
        this.metragem = metragem;
    }

    public Double getValor_aluguel_sug() {
        return valor_aluguel_sug;
    }

    public void setValor_aluguel_sug(Double valor_aluguel_sug) {
        this.valor_aluguel_sug = valor_aluguel_sug;
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
        Imovel imovel = (Imovel) o;
        return Objects.equals(id, imovel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", endereco='" + endereco + '\'' +
                ", valor='" + valor_aluguel_sug + '\'' +
                '}';
    }
}
