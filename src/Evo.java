/**
 * @Author PJ.Rivera
 */
public class Evo {

    /**
     *
     * @param args
     */
    public static void main(String[] args){

        /**
         *  La forma clásica de Java de invocar a un objeto, éste tiene asociado el método imprime();
         */

        Claseauxiliar aux=new Claseauxiliar("Saludos desde la forma tradicional");
        aux.imprime();

        /**
         *  Implementación mas rápida que podremos usar cuando necesitemos implementar una interface de una forma interna, disponible desde la versión 1.1 de Java
         */

        new Impresor(){
            @Override
            public void imprime(){

                System.out.println("Esto se imprime desde la clase ánonima");

            }
        }.imprime();

        /**
         * Las funciones Lambda disponibles desde java 8 resultan una forma util y sencilla de implementar las funcionalidades de una interface.
         */

        Impresor variableFuncional = ()-> System.out.println("Y así es la evolución");

        variableFuncional.imprime();

    }

    /**
     *  Interface con un método que no retorna nada.
     */

    public interface Impresor{
        void imprime();
    }

    /**
     *  Clase que implementa la interface, su método imprime en la consola la propiedad mensaje.
     */

    static class Claseauxiliar implements Impresor{
        String mensaje;
        public Claseauxiliar(String mensaje) {
            this.mensaje = mensaje;
        }
        @Override
        public void imprime() {
            System.out.println(mensaje);
        }
    }
}
