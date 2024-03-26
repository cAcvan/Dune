import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static Map<String, CuerpoCeleste> sistemaSolar = new HashMap<>();
    public static Set<CuerpoCeleste> planetas = new HashSet<>();

    public static void main(String[] args) {
        CuerpoCeleste Mercurio = new Planeta("Mercurio", 88);
        planetas.add(Mercurio);
        sistemaSolar.put("Mercurio", Mercurio);

        CuerpoCeleste Venus = new Planeta("Venus", 225);
        planetas.add(Venus);
        sistemaSolar.put("Venus", Venus);

        CuerpoCeleste La_Tierra = new Planeta("La_Tierra", 365);
        planetas.add(La_Tierra);
        sistemaSolar.put("La Tierra", La_Tierra);

        CuerpoCeleste Marte = new Planeta("Marte", 687);
        planetas.add(Marte);
        sistemaSolar.put("Marte", Marte);

        CuerpoCeleste Jupiter = new Planeta("Jupiter", 4332);
        planetas.add(Jupiter);
        sistemaSolar.put("Jupiter", Jupiter);

        CuerpoCeleste Saturno = new Planeta("Saturno", 10759);
        planetas.add(Saturno);
        sistemaSolar.put("Saturno", Saturno);

        CuerpoCeleste Urano = new Planeta("Urano", 30660);
        planetas.add(Urano);
        sistemaSolar.put("Urano", Urano);

        CuerpoCeleste Neptuno = new Planeta("Neptuno", 165);
        planetas.add(Neptuno);
        sistemaSolar.put("Neptuno", Neptuno);

        CuerpoCeleste Pluton = new Planeta("Pluton", 248);
        planetas.add(Pluton);
        sistemaSolar.put("Pluton", Pluton);

        CuerpoCeleste Luna = new Luna("Luna", 27);
        sistemaSolar.put("Luna", Luna);
        La_Tierra.addSatelite(Luna);

        CuerpoCeleste Deimos = new Luna("Deimos", 1.3);
        CuerpoCeleste Phobos = new Luna("Phobos", 0.3);
        sistemaSolar.put("Deimos", Deimos);
        sistemaSolar.put("Phobos", Phobos);
        Marte.addSatelite(Deimos);
        Marte.addSatelite(Phobos);

        CuerpoCeleste lo = new Luna("lo", 1.8);
        CuerpoCeleste Europa = new Luna("Europa", 3.5);
        CuerpoCeleste Gaymede = new Luna("Gaymede", 7.1);
        CuerpoCeleste Callisto = new Luna("Callisto", 16.7);
        sistemaSolar.put("lo", lo);
        sistemaSolar.put("Europa", Europa);
        sistemaSolar.put("Gaymede", Gaymede);
        sistemaSolar.put("Callisto", Callisto);
        Jupiter.addSatelite(lo);
        Jupiter.addSatelite(Europa);
        Jupiter.addSatelite(Gaymede);
        Jupiter.addSatelite(Callisto);

        int cont = 1;
        for(CuerpoCeleste c : planetas){
            System.out.println("Nombre del planeta " + cont + "º: " + c);
            cont++;
        }
        System.out.println();

        Set<CuerpoCeleste> LunasMarte = Marte.getSatelites();

        for(CuerpoCeleste c : LunasMarte){
            System.out.println(c.getNombre());
        }

        Set<CuerpoCeleste> lunas = new HashSet<CuerpoCeleste>();

        for(Map.Entry<String, CuerpoCeleste> entry : sistemaSolar.entrySet()){
            if(entry.getValue().getTipoCuerpo().equals(CuerpoCeleste.TipoCuerpoCeleste.LUNA)){
                lunas.add(entry.getValue());
            }
        }

        System.out.println();

        System.out.println("Lista de lunas: ");
        for(CuerpoCeleste c : lunas){
            System.out.println(c);
        }
    }
}
