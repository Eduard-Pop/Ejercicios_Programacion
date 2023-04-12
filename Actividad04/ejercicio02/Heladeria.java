
import java.util.Scanner;

public class Heladeria {
    
    private Utilidades ut;
    private Comida [] pedido;
    private Scanner sc;
    
    public Heladeria(int total_productos){
        ut = new Utilidades();
        if(total_productos < 4){
            total_productos = 4;
        }
        pedido = new Comida[total_productos];
        introducirProductos();
        initMenu();
    }
    
    
    public static int cantidadProductos() {
        Scanner sc = new Scanner(System.in);
        int t = -1;
        System.out.println("Introducir total de productos pedido: ");
        while (t <= 0) {
            try {
                if (t == 0) {
                    System.out.println("\n!!!Valor incorrecto...");
                    System.out.println("Volver a intentar: ");
                }
                t = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                t = 0;
            }
        }
        return t;
    }
    

    private void introducirProductos(){
        Comida cacahuete = new Comida("cacahuetes", 2.5, "99 Kcal");
        Comida horchata = new Horchata("horchata", 2.5, 20 , 250, 30);
        

        Cucurucho cucurucho1 = new Cucurucho("cucurucho", 1, 20, 2);
        Comida sabor1 = new SaborHelado("vainilla", 1, 30 , 15, "azucar");
        Comida sabor2 = new SaborHelado("chocolate", 1, 12, 15, "aspartamo");
        cucurucho1.addBolaHelado((SaborHelado) sabor1, 0);
        cucurucho1.addBolaHelado((SaborHelado) sabor2, 1);
        
        Cucurucho cucurucho2 = new Cucurucho("cucurucho galleta_chocolate", 1.5, 25, 2);
        Comida s1 = new SaborHelado("cookies", 1, 35, 20, "azucar");
        Comida s2 = new SaborHelado("fresa", 1, 10, 5, "aspartamo");
        cucurucho2.addBolaHelado((SaborHelado) s1, 0);
        cucurucho2.addBolaHelado((SaborHelado) s2, 1);
        
        pedido[0] = cacahuete;
        pedido[1] = horchata;
        pedido[2] = cucurucho1;
        pedido[3] = cucurucho2;
    }
    
    
    private void initMenu(){
        sc = new Scanner(System.in);
        char c = ' ';
        do {
            mostrarPedido();
            System.out.println("s/S - Salir");
            System.out.println("e/E - Editar");
            System.out.println(" Seleccionar opción: ");
            c = sc.next().charAt(0);
            if(c == 'e' || c == 'E'){
                editarPedido();
            }
        } while(c != 's' && c != 'S');
    }
    
    private void mostrarPedido(){
        int contador = 1;
        System.out.println("\n----------------------- Listado pedido ----------------------------------------------------------\n");
        for(Comida aux: pedido){
            if(aux != null){
                if(aux instanceof SaborHelado){
                  System.out.println(aux);    
                } else {
                    System.out.println((contador++) +" - "+ aux);   
                }
            }
        }
        System.out.println("\n ------------------------------------------------------------------------------------------------\n");
    }
    
    private void editarPedido() {
        sc = new Scanner(System.in);
        int pos = -1;
        System.out.println("\n Esribir número producto a editar: ");
        while (pos <= 0 || pos > pedido.length) {
            if (pos == 0 || pos > pedido.length) {
                System.out.println("!!!Valor incorrecto, volver a probar: ");
            }
            try {
                pos = Integer.parseInt(sc.nextLine());
                nuevoProducto(pos);
            } catch (NumberFormatException e) {
                pos = 0;
            }
        }
    }
    
    private void nuevoProducto(int pos){
        pedido[pos-1] = null;
        System.out.println("Escribir datos nuevo producto...");
        String nombre = ut.pideString("Nombre: ");
        double precio = ut.pideDouble("Precio: ");
        double kcal = ut.pideDouble("Kcal :");
        
        if(nombre.equalsIgnoreCase("horchata")){
            int cantidad = ut.pideEntero("Cantidad: ");
            int por_chufa = ut.pideEntero("Porcentaje chufa: ");
            Comida horchata = new Horchata(nombre, precio, kcal, cantidad, por_chufa);
            pedido[pos-1] = horchata;
            
        } else if(nombre.equalsIgnoreCase("cucurucho")){
            int bolas = ut.pideEntero("Número de bolas helado: ");
            SaborHelado [] sb = new SaborHelado[bolas];
            for (int i = 0; i < sb.length; i++) {
                String sabor = ut.pideString("Sabor bola helado "+(i+1)+": ");
                double precio_bola = ut.pideDouble("Precio bola: ");
                double kcal_bola = ut.pideDouble("Kcal bola: ");
                int por_grasa = ut.pideEntero("Porcentaje grasa: ");
                String edulcorante = ut.pideString("Edulcorante: ");
                SaborHelado s = new SaborHelado(sabor, precio_bola, kcal_bola, por_grasa, edulcorante);
                sb[i] = s;
            }
            Cucurucho c = new Cucurucho(nombre, precio, kcal, bolas);
            int contador = 0;
            for(SaborHelado aux: sb){
                c.addBolaHelado(aux, contador++);
            }
            pedido[pos-1] = c;
        } else {
            Comida n = new Comida(nombre, precio, kcal);
            pedido[pos-1] = n;
        }
         System.out.println(" Se ha realizado la edición...");   
    }
    
    public static void main(String[] args) {
        System.out.println("Inicio pedido...");
        int t = Heladeria.cantidadProductos();
        new Heladeria(t);
    }
    
}
