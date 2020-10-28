import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Con esta clase se pretende entender la sintaxisis y construcción de las funciones lambda.
 */

public class JavaLambda {

    /**
     * Ejecución principal en la que iremos probando distintas sintaxis y formas de construcción de lambdas.
     * @param args
     */

    public static void main(String[] args) {

        primerTest();

        System.out.println("*******");

        segundoTest();

        System.out.println("*******");

        StringFuncion exclamacion = (s) -> s + "!";
        StringFuncion interrogante = (s) -> s + "?";

        StringFuncion excla = String::toUpperCase;
        System.out.println(excla.cambiaMensaje("mensaje en mayúsculas"));

        cambiaMensaje("Añade excalamción", exclamacion);
        cambiaMensaje("Añadirá interrogante", interrogante);

        System.out.println("*******");

        //Ejemplos de interfaces funcionales ya creadas

        //Predicado recibe un argumento y devuelve un valor lógico
        Function<String, Integer> tamanioCadenaPredicado = str -> str.length();
        String cadena = "Lambdas tipo funciones";
        System.out.println("Número de caracteres es : " + tamanioCadenaPredicado.apply(cadena));

        System.out.println("*******");

        //Function recibe un argumento y devuelve un resultado
        Function<Integer, Integer> suma = x -> x + 8;
        System.out.println("La suma de 5 + 8: " + suma.apply(5));

        Function<String, Integer> tamanioCadenaFuncion = str -> str.length();
        String parrafo = "Lambdas tipo funciones";
        System.out.println("Número de caracteres es : " + tamanioCadenaFuncion.apply(cadena));

        //Proveedores no tienen parametros pero devuelven un resultado
        Supplier<String> frase = () -> "Ejemplo de Proveedor";
        System.out.println(frase.get());

        LinkedList<Integer> lista = new LinkedList<Integer>(Arrays.asList(1, 2, 3));
        Supplier<Integer> funcionProveedor = lista::removeLast;
        System.out.println("Número eliminado por el proveedor:");
        System.out.println(funcionProveedor.get()); // 3
        System.out.println("Números restantes en la lista:");
        lista.forEach(System.out::println);

        //Consumidores, tienen un parametro de entrada pero no devuelven nada
        Consumer<Integer> impresor= i->System.out.println(i);
        ArrayList<Integer> numeros=new ArrayList<Integer>();
        numeros.add(3);
        numeros.add(5);
        numeros.add(7);
        System.out.println("Impresión de números realizada por el consumidor:");
        numeros.forEach(n->impresor.accept(n));
    }

    /**
     * Implementación más simple, atención al parámetro, al ser solo uno no es necesario utilizar () para encapsularlo.
     * Ocurre lo mismo con el cuerpo, al ser una sola instrucción no necesitamos llaves.
     */

    public static void primerTest(){
        ArrayList<Integer> numeros=new ArrayList<Integer>();

        numeros.add(3);
        numeros.add(5);
        numeros.add(7);

        numeros.forEach( n -> System.out.println(n));

        numeros.forEach(System.out::println);
    }

    /**
     * Implementación con varios parametros y dos sentencias en el cuerpo, necesitamos {} para ellos y () para los
     * parámetros.
     */

    public static void segundoTest() {
       HashMap<Integer,Integer> numeros=new HashMap<>();
       numeros.put(100,3);
       numeros.put(200,5);
       numeros.put(300,7);

       numeros.forEach( (n,x) -> {
           n=n/100;
           System.out.println("La clave es: "+n+". El valor es: "+x);
       });
    }

    /**
     * Esta interface se considera funcional, ya que posee solo un método abastracto no heredado de Object
     * esta comprobación la realiza el compilador mediante la anotación @FuncionalInterface en caso de no cumplir
     * con el requisito de un único método devolverá "Stringfuncion is not a functional interface"
     */
    @FunctionalInterface
    interface StringFuncion {
        String cambiaMensaje(String mensaje);
    }


    public static void cambiaMensaje(String mensaje, StringFuncion funcion) {
            String resultado = funcion.cambiaMensaje(mensaje);
            System.out.println(resultado);
    }

}
