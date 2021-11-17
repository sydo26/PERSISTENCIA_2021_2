package com.lista04.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface DaoCommon<O> {

    /** Salva um novo objeto no banco */
    public O save(O obj) throws SQLException;

    /** Salva dados fakes */
    public O saveFake() throws SQLException;

    /** Lista todos os objetos do banco */
    public List<O> findAll() throws SQLException;

    /** Pega o primeiro objeto que possui os dados informados */
    public O findFirst(O obj) throws SQLException;

    /** Deleta o um objeto que possui o identificador */
    public O deleteUnique(Integer id) throws SQLException;
}
