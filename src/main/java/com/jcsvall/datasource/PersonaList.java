/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcsvall.datasource;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author scjuan
 */
public class PersonaList {

    public static List<Persona> load() {
        List<Persona> p = new ArrayList<>();
        p.add(new Persona("Juan", 34));
        p.add(new Persona("Juan2", 34));
        p.add(new Persona("Juan3", 34));
        return p;
    }

    public static List<SolicitudCitesPojo> loadSolicitud() {
        List<SolicitudCitesPojo> citesList = new ArrayList<>();
        SolicitudCitesPojo ciObject = new SolicitudCitesPojo();

        ciObject.setImportacion("X");
        ciObject.setExportacion("");
        ciObject.setReExportacion("");
        ciObject.setOtros("");
        ciObject.setPermisoCertificado("permisoCertificado");
        ciObject.setValidoHasta("validoHasta");
        ciObject.setImportador("Wallmart S.A de C.V");
        ciObject.setExportador("Dell International");
        ciObject.setPaisDeImportacion("EL Salvador");

        citesList.add(ciObject);

        return citesList;
    }
}
