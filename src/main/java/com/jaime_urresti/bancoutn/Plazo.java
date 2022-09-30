package com.jaime_urresti.bancoutn;

public class Plazo {

    private String nombre;
    private String apellido;
    private String moneda;
    private Double tasaNominal;
    private Double tasaEfectiva;
    private Integer dias;
    private boolean renovacionAutomatica;
    private Double capital;
    private boolean habilitado;

    public Double getCapital() {
        return capital;
    }

    public void setCapital(Double capital) {
        this.capital = capital;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Double getTasaNominal() {
        return tasaNominal;
    }

    public void setTasaNominal(Double tasaNominal) {
        this.tasaNominal = tasaNominal;
    }

    public Double getTasaEfectiva() {
        return tasaEfectiva;
    }

    public void setTasaEfectiva(Double tasaEfectiva) {
        this.tasaEfectiva = tasaEfectiva;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public boolean isRenovacionAutomatica() {
        return renovacionAutomatica;
    }

    public void setRenovacionAutomatica(boolean renovacionAutomatica) {
        this.renovacionAutomatica = renovacionAutomatica;
    }
}
