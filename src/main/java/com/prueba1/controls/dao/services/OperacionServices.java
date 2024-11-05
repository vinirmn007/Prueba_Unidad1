package com.prueba1.controls.dao.services;

import com.prueba1.list.*;
import com.prueba1.controls.dao.OperacionDao;
import com.prueba1.models.Operacion;

public class OperacionServices {
    OperacionDao operacion;

    public OperacionServices() {
        this.operacion = new OperacionDao();
    }

    public Boolean save() throws Exception {
        return operacion.save();
    }

    public Boolean update() throws Exception {
        return operacion.update();
    }

    public LinkedList<Operacion> listAll() {
        return operacion.getListAll();
    }

    public Operacion getOperacion() {
        return operacion.getOperacion();
    }

    public void setOperacion(Operacion operacion) {
        this.operacion.setOperacion(operacion);
    }

    /*public Operacion get(Integer id) throws Exception{
        return operacion.get(id)
    }*/
}
