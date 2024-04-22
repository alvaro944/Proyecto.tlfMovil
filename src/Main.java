import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("\n0 - Salir");
        System.out.println("1 - Imprimir contactos");
        System.out.println("2 - Agregar nuevos contacto");
        System.out.println("3 - Actualizar un contacto existente");
        System.out.println("4 - Eliminar un contacto");
        System.out.println("5 - Buscar un contacto por nombre");
        System.out.println("6 - Mostrar menú");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu();
        int opcion = -1;

        // Creo algunos contactos y un teléfono para probar

        TelefonoMovil telefonoMovil = new TelefonoMovil("699639825");
        Contacto contacto1 = new Contacto("Pepe", "31415926");
        Contacto contacto2 = new Contacto("Alicia", "16180339");
        Contacto contacto3 = new Contacto("Tomás", "11235813");
        Contacto contacto4 = new Contacto("Jessica", "23571113");

        telefonoMovil.addNewContact(contacto1);
        telefonoMovil.addNewContact(contacto2);
        telefonoMovil.addNewContact(contacto3);
        telefonoMovil.addNewContact(contacto4);


        while (opcion!=0){
            System.out.print("\n[+] Elige una opción: ");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    telefonoMovil.printContacts();
                    break;
                case 2:
                    System.out.print("\n[*] Introduce el nombre del contacto: ");
                    String nombreAdd = sc.next();
                    System.out.print("[*] Introduce el teléfono del contacto: ");
                    String telefonoAdd = sc.next();

                    Contacto contacto = new Contacto(nombreAdd, telefonoAdd);
                    telefonoMovil.addNewContact(contacto);

                    break;
                case 3:
                    try {
                        System.out.print("\n[*] Introduce el nombre del contacto que quieres modificar: ");
                        String nombreBusq = sc.next();
                        Contacto contAnt = telefonoMovil.queryContact(nombreBusq);

                        System.out.print("[*] Introduce el nombre del contacto nuevo: ");
                        String nombreMod = sc.next();
                        System.out.print("[*] Introduce el teléfono del contacto nuevo: ");
                        String telefonoMod = sc.next();
                        Contacto contNuevo = new Contacto(nombreMod, telefonoMod);

                        if (telefonoMovil.updateContact(contAnt, contNuevo)) {
                            System.out.println("\n[+] Se ha actualizado el contacto exitosamente");
                        } else {
                            throw new Exception();
                        }
                    } catch (Exception e){
                        System.out.println("\n[!] No se ha podido actualizar el contacto");
                    }

                    break;
                case 4:
                    System.out.print("\n[*] Introduce el nombre del contacto a eliminar: ");
                    String nombreDel = sc.next();

                    Contacto contDel = telefonoMovil.queryContact(nombreDel);
                    if(telefonoMovil.removeContact(contDel)){
                        System.out.println("[+] Contacto eliminado correctamente");
                    } else {
                        System.out.println("[!] El contacto no exite, no se puede eliminar");
                    }
                    break;
                case 5:
                    System.out.print("[*] Introduce el nombre del contacto a buscar: ");
                    String nombreBus = sc.next();

                    Contacto contBus = telefonoMovil.queryContact(nombreBus);
                    System.out.println("[+] La información del contacto es: \n\t" + contBus.toString());
                    break;
                case 6:
                    menu();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
        sc.close();
    }
}