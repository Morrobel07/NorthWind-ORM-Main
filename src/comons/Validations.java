package comons;

public class Validations {

    public Validations() {// ESTE ENUM CONTIENE FUNCIONES PARA VALIDAR LOS CAMPOS EN EL ENUM CREATE
                          // ENTITIES

    }

    public boolean validationsStrings(String input) {
        // strings A-z

        if (!input.matches("[a-zA-ZÁ-ÿ.\\s]+") || input.length() > 30 || input.trim().isEmpty()) {
            System.out.print("\n*****HERROR! ");
            System.out.println("Solo puedes introducir letras en este campo con un máximo de 30 caracteres");
            return false;
        } else {
            return true;
        }
    }

    // strings desde la a-z, espacios y el signo '#'
    public boolean addressValidations(String input) {
        if (!input.matches("[a-zA-Z0-9#,\\s]+") || input.length() > 30 || input.trim().isEmpty()) {
            System.out.print("\n*****HERROR! ");
            System.out.println("Solo puedes introducir letras, números, espacios y el signo '#' en este campo");
            return false;
        } else {
            return true;
        }
    }

    // validations postal
    public boolean postalCodeValidations(String input) {
        if (!input.matches("[0-9]+") || input.length() > 5 || input.trim().isEmpty()) {
            System.out.print("\n****HERROR! ");
            System.out.println("Solo puedes introducir números en este campo con un máximo de 5 digitos");
            return false;
        } else {
            return true;
        }
    }

    public boolean numberPhoneValidations(String input) {
        if (!input.matches("(809|829|849)(-[0-9]{3}-[0-9]{4}|[0-9]{7})")) {
            System.out.println("\nHERROR ");
            System.out.println("El número telefónico tiene un formato inválido");
            return false;
        } else {
            return true;
        }
    }

    public boolean extensionNumber(String input) {
        if (!input.matches("[0-9]")) {
            System.out.print("\n*****HERROR! ");
            System.out.println("La extensión debe ser un digito entre 0 y 9");
            return false;
        } else
            return true;
    }

    public boolean quantityValidation(String input) {
        if (!input.matches("[1-9]+")) {
            System.out.print("\n*****HERROR! ");
            System.out.println("Solo puedes ingresar números enteros mayor que 0");
            return false;
        } else {
            return true;
        }
    }

}