package visual;

import java.util.ArrayList;
import model.Estadio;

import javax.swing.AbstractListModel;

public class Model_Estadio extends AbstractListModel
{
    private ArrayList <Estadio> lstEstadios = new ArrayList<Estadio>();

	// actualiza la vista
	public void refresh () {
		this.fireIntervalAdded(this, 0, getSize());
	}

    // establece la lista de Estadios al modelo
	public void setlstEstadios(ArrayList<Estadio> lstEstadios) {
		this.lstEstadios = lstEstadios;
		this.fireIntervalAdded(this, 0, getSize());
	}
    
	// devuelve el tama�o de la lista del modelo
	public int getSize() {
		return lstEstadios.size();
	}

	// devuelve el elemento de la posici�n index dentro del modelo
	public Object getElementAt(int indice) {
        Estadio x = null;
		if (indice > -1 && indice < this.getSize())
			x = lstEstadios.get(indice);
		return x;
	}

	// agrega un estadio al final de la lista del modelo
	public void addEstadio(Estadio p) {
		lstEstadios.add(p);
		this.fireIntervalAdded(this, getSize(), getSize());
	}

	// agrega un estadio al modelo en la posici�n indice
	public Estadio getEstadioAt(int indice) {
		Estadio x = null;
		if (indice > -1 && indice < this.getSize())
			x = lstEstadios.get(indice);
		return x;
	}

	// elimina un estadio del modelo que ocupa la posici�n indice
	public void removeEstadio (int indice) {
		if (indice > -1 && indice < this.getSize()) {
			lstEstadios.remove(indice);
			this.fireIntervalRemoved(this, indice, indice);
		}
	}
	// modifica en el modelo los valores del estadio en la posici�n indice
	public void updateEstadio (int indice, Estadio c) {
		if (indice > -1 && indice < this.getSize()) {
			lstEstadios.set(indice, c);
			this.fireContentsChanged(this, indice, indice);
		}
	}
}
