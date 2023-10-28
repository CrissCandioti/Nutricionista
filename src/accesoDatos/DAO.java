/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * La calse abstracta DAO es la encargada de establecer la comuniacion con
 * nuestro programa y la base de datos creada con anterioridad. Esta clase va a
 * contener los metodos de conectarBaseDatos, desconectarBaseDatos,
 * insertarModificarEliminarBaseDatos y consultarBaseDatos.Esta misma clase va a
 * heredar a las otras clases DAO de las entidades creadas. El patrón DAO (Data
 * Access Object) es un patrón de diseño de software que se utiliza en la
 * programación orientada a objetos para separar la lógica de acceso a datos de
 * una aplicación.
 */
public abstract class DAO {

    /**
     * Estas variables son las que van a ir tomando distintos valores de nuestra
     * base de datos. La cual ingresaremos informacion,consultaremos
     * informacion,modificaremos informacion y eliminaremos informacion de la
     * base de datos creada con anterioridad.
     */
    protected Connection coneccion = null;//La variable coneccion es la mas importante, porque es la encargada en la comunicacion con la base de datos.
    protected Statement sentencia = null;//La variable resultado es la que extrae la informacion de la base de datos para mostrarla, no realiza ninguna modificacion.
    protected ResultSet resultado = null;//La variable sentencia es la que almacena la infromacion de los comandos para insertar,modifica,eliminar de la base.

    private final String USER = "root";
    private final String PASSWORD = "";
    private final String DATABASE = "nutricion1";
    private final String DRIVER = "org.mariadb.jdbc.Driver";

    /*
     * Metodo que va a heredar a sus clases hijas la cual realiza la coneccion a
     * la base de datos.
     */
    protected void coneccionBaseDatos() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String urlBaseDatos = "jdbc:mariadb://localhost:3306/" + DATABASE + "?zeroDateTimeBehavior=convertToNull";
            coneccion = DriverManager.getConnection(urlBaseDatos, USER, PASSWORD);
            // Deshabilitar el modo de autocommit
            coneccion.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    /*
     * Metodo que va a heredar a sus clases hijas la cual realiza la
     * desconeccion a la base de datos.
     */
    protected void desconectarBaseDatos() {
        try {
            /**
             * Estos condicionales if se encargan de cerrar la comunicacion y
             * coneccion con la base de datos.
             */
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (coneccion != null) {
                /**
                 * Dentro de esta condición, se verifica si la conexión a la
                 * base de datos no está en modo de "auto commit." En una base
                 * de datos, el modo de "auto commit" significa que cada
                 * sentencia SQL individual se confirma automáticamente y se
                 * convierte en una transacción independiente. Si
                 * getAutoCommit() devuelve false, significa que la conexión
                 * está configurada para trabajar en modo de transacciones, lo
                 * que permite agrupar varias operaciones en una transacción y
                 * confirmarlas o revertirlas en conjunto.
                 */
                if (!coneccion.getAutoCommit()) {
                    /**
                     * Si la conexión no está en modo de "auto commit," se
                     * ejecuta un rollback en la conexión. El rollback deshace
                     * cualquier cambio pendiente en la transacción actual. Esto
                     * es útil si, por alguna razón, la transacción no se
                     * completó con éxito y se desean deshacer los cambios antes
                     * de cerrar la conexión.
                     */
                    coneccion.rollback();
                }
                coneccion.close();
            }
        } catch (SQLException e) {
            System.out.println("No pudimos desconectarnos desconectado");
        }
    }

    /*
     * Metodo creado para encargarse de las operaciones con la base de datos,
     * estas son las de insertar,modificar,eliminar. El metodo recibe por
     * parametro la consulta. Cabe mencionar que el método
     * insertarModificarEliminarBaseDatos no está sobrecargado de tareas, ya que
     * esta diseñado para realizar una tarea específica: ejecutar una consulta
     * SQL en la base de datos. Su función principal es ejecutar consultas SQL
     * en la base de datos, y puede ser utilizado para realizar operaciones de
     * inserción, modificación o eliminación de datos, dependiendo de la
     * consulta SQL que se le pase como argumento.
     */
    protected void insertarModificarEliminarBaseDatos(String sql) throws SQLException, ClassNotFoundException, Exception {
        try {
            coneccionBaseDatos();
            sentencia = coneccion.createStatement();
            /**
             * El createStatement se utiliza para ejecutar una consulta SQL
             * directamente tal como se proporciona. Esto significa que la
             * consulta SQL se pasa como una cadena directamente en el método
             * executeQuery o executeUpdate y se ejecuta tal cual. No se
             * realizan preparaciones previas de la consulta.
             */
            sentencia.executeUpdate(sql);
            // Confirmar la transacción
            coneccion.commit();
        } catch (SQLException | ClassNotFoundException e) {
            if (coneccion != null) {
                coneccion.rollback();
            }
            throw e;
        } finally {
            desconectarBaseDatos();
        }
    }

    /*
     * Metodo creado para encargarse de las consulta, busca y retorna la
     * informacion solicitada. Este metodo tambien recibe por parametro la
     * consulta.
     */
    protected void consultarBaseDatos(String sql) throws Exception {
        try {
            coneccionBaseDatos();
            sentencia = coneccion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception e) {
            if (coneccion != null) {
                coneccion.rollback();
            }
            throw e;
        }
    }
    /**
     * La desconeccion de la base de datos con el metodo consultar la haremos
     * dentro de los metodos de las clases hijas de DAO.
     */
}
/**
 * En esta base de datos se aplico un "rollback". El rollback garantiza que la
 * base de datos no quede en un estado inconsistente si ocurre un error durante
 * una transacción. Por ejemplo, se refiere a una operación en una base de datos
 * que revierte una transacción a su estado previo, anulando todos los cambios
 * que se han realizado en el transcurso de la transacción.
 */
