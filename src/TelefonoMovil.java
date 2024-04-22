import java.util.ArrayList;

public class TelefonoMovil {
    private String myNumber;
    private ArrayList<Contacto> myContact;

    public TelefonoMovil(String myNumber){
        this.myNumber = myNumber;
        this.myContact = new ArrayList<>();
    }

    public boolean addNewContact(Contacto contacto){
        if (findContact(contacto) >= 0) {
            return false;
        }
        myContact.add(contacto);
        return true;
    }

    public boolean updateContact(Contacto contAnt, Contacto contNuevo){
        int indice = findContact(contAnt);
        if (indice < 0 || findContact(contNuevo) >= 0) {
            return false;
        }
        myContact.set(indice, contNuevo);
        return true;

    }


    public boolean removeContact(Contacto contacto){
        int position = findContact(contacto);
        if (position < 0) {
            return false;
        }
        myContact.remove(position);
        return true;
    }

    public int findContact(Contacto contacto){
        if(myContact.contains(contacto)){
            return myContact.indexOf(contacto);
        }
        return -1;
    }

    public int findContact(String nombre){
        for(Contacto contacto : myContact){
            if(contacto.getName().equals(nombre)){
                return myContact.indexOf(contacto);
            }
        }
        return -1;
    }


    public Contacto queryContact(String nombre){
        for (Contacto contacto : myContact){
            if (contacto.getName().equals(nombre)){
                return contacto;
            }
        }
        return null;
    }

    public void printContacts(){
        int contador = 1;
        System.out.println("\n[+] Lista de contactos:");
        for(Contacto contacto : myContact){
            System.out.print("\t" + contador++ + ". ");
            System.out.println(contacto.toString());
        }

    }


}
