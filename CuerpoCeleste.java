import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CuerpoCeleste {
    public enum TipoCuerpoCeleste {ESTRELLA, PLANETA, PLANETA_ENANO, LUNA, COMETA, ASTEROIDE};
    private String nombre;
    private double periodoOrbital;
    private Set<CuerpoCeleste> satelites;
    private TipoCuerpoCeleste tipoCuerpo;

    public CuerpoCeleste(String nombre, double periodo, TipoCuerpoCeleste tipo){
        this.nombre=nombre;
        this.periodoOrbital=periodo;
        this.tipoCuerpo=tipo;
        satelites = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

    public Set<CuerpoCeleste> getSatelites() {
        Set<CuerpoCeleste> newSatelite = new HashSet<>();
        newSatelite.addAll(satelites);
        return newSatelite;
    }

    public boolean addSatelite(CuerpoCeleste c){
        if(satelites.contains(c)){
            return false;
        }else{
            satelites.add(c);
            return true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuerpoCeleste that = (CuerpoCeleste) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(satelites, that.satelites) && tipoCuerpo == that.tipoCuerpo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, satelites, tipoCuerpo);
    }

    @Override
    public String toString() {
        return nombre + ": " + tipoCuerpo + ", " + periodoOrbital + ".";
    }
}

class Planeta extends CuerpoCeleste{
    public Planeta(String nombre, double periodo) {
        super(nombre, periodo, TipoCuerpoCeleste.PLANETA);
    }

    @Override
    public boolean addSatelite(CuerpoCeleste c) {
        if(c.getTipoCuerpo().equals(TipoCuerpoCeleste.LUNA)){
            getSatelites().add(c);
            return true;
        }else
            return false;
    }
}

class PlanetaEnano extends CuerpoCeleste{
    public PlanetaEnano(String nombre, double periodo){
        super(nombre, periodo, TipoCuerpoCeleste.PLANETA_ENANO);
    }
}

class Luna extends CuerpoCeleste{
    public Luna(String nombre, double periodo){
        super(nombre, periodo, TipoCuerpoCeleste.LUNA);
    }
}
