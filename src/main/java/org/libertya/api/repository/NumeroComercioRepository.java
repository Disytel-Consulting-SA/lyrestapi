package org.libertya.api.repository;

import org.libertya.api.stub.model.NumeroComercio;
import org.springframework.stereotype.Repository;

/**
 * Maestro de numeros de comercio, de solo lectura.
 *
 * A diferencia del resto de los repositorios, el nombre de la tabla va como literal y no como la constante
 * Table_Name de una clase X_*: M_NumeroComercio no tiene clase generada en org.openXpertya.model. Es una tabla
 * de plugin (AD_Component con corelevel=2 y packagename com.hipertehuelche.sucursales), asi que su unica clase
 * es com.hipertehuelche.sucursales.model.MNumeroComercio, y el codigo de este repo no importa ese paquete a
 * proposito para seguir compilando contra el core publico. M_Table.getClass() la resuelve igual en tiempo de
 * ejecucion a partir del owner que declara el diccionario.
 *
 * Ver docs/liquidaciones-tarjetas-api.md
 */
@Repository
public class NumeroComercioRepository extends AbstractRepository {

    public NumeroComercioRepository() {
        tableName = "M_NumeroComercio";
        iface = NumeroComercio::new;
    }
}
