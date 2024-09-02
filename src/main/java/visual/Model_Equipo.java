package visual;

import java.util.ArrayList;
import model.Equipo;

import javax.swing.AbstractListModel;

public class Model_Equipo extends AbstractListModel
{
    private ArrayList <Equipo> lstEquipos = new ArrayList<Equipo>();

	// actualiza la vista
	public void refresh () {
		this.fireIntervalAdded(this, 0, getSize());
	}

    // establece la lista de Equipos al modelo
	public void setlstEquipos(ArrayList<Equipo> lstEquipos) {
		this.lstEquipos = lstEquipos;
		this.fireIntervalAdded(this, 0, getSize());
	}
    
	// devuelve el tama�o de la lista del modelo
	public int getSize() {
		return lstEquipos.size();
	}

	// devuelve el elemento de la posici�n index dentro del modelo
	public Object getElementAt(int indice) {
        Equipo x = null;
		if (indice > -1 && indice < this.getSize())
			x = lstEquipos.get(indice);
		return x;
	}

	// agrega un estadio al final de la lista del modelo
	public void addEquipo(Equipo p) {
		lstEquipos.add(p);
		this.fireIntervalAdded(this, getSize(), getSize());
	}

	// agrega un estadio al modelo en la posici�n indice
	public Equipo getEquipoAt(int indice) {
		Equipo x = null;
		if (indice > -1 && indice < this.getSize())
			x = lstEquipos.get(indice);
		return x;
	}

	// elimina un elemento del modelo que ocupa la posici�n indice
	public void removeEquipo (int indice) {
		if (indice > -1 && indice < this.getSize()) {
			lstEquipos.remove(indice);
			this.fireIntervalRemoved(this, indice, indice);
		}
	}
	// modifica en el modelo los valores en la posici�n indice
	public void actualizarEquipo (int indice, Equipo c) {
		if (indice > -1 && indice < this.getSize()) {
			lstEquipos.set(indice, c);
			this.fireContentsChanged(this, indice, indice);
		}
	}
}
