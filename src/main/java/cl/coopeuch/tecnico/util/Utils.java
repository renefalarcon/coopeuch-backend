package cl.coopeuch.tecnico.util;

public final class Utils {

    private Utils() {
        throw new IllegalStateException("Clase Utilitaria");
    }

    /**
     * Mensajes de respuesta
     */

    public static final String ListaTareaVacia = "La lista no contiene datos";
    public static final String ListaTareaOk = "Lista de tareas obtenida exitosamente";
    public static final String TareaEliminada = "Tarea eliminada exitosamente";
    public static final String TareaNoEliminada = "Problemas al eliminar la tarea";
    public static final String TareaAgregada = "Tarea agregada exitosamente";
    public static final String TareaModificada = "Tarea modificada exitosamente";

    /**
     * Mensajes de Errores
     */

    public static final String error = "Error encontrado ";
    public static final String RESOURCENOTFOUND = "Problemas al ejecutar la operacion ";

    /**
     * Codigos
     */

    public static final String codOK = "000";
    public static final String codNOK = "001";

    /**
     * Validacion
     */

    public static final String noNulo="El valor no puede ser nulo";
    public static final String noBlanco="Este valor no puede ser vacio";
    public static final String esBolean="Este valor debe ser un boolean true o false";
}
