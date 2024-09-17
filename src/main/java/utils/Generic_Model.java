package utils;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class Generic_Model<E> extends AbstractListModel {
	private ArrayList<E> list = new ArrayList<E>();

	// actualiza la vista
	public void refresh() {
		this.fireIntervalAdded(this, 0, getSize());
	}

	// obtiene la lista de elementos en el modelo
	public ArrayList<E> getList () {
		return list;
	}

	// establece la lista de elementos en el modelo
	public void setList(ArrayList<E> list) {
		this.list = list;
		// this.fireIntervalAdded(this, 0, getSize());
	}

	// devuelve el tamaño de la lista del modelo
	public int getSize() {
		return list.size();
	}

	// devuelve el elemento de la posición index dentro del modelo
	public E getElementAt(int index) {
		E x = null;
		if (index > -1 && index < this.getSize())
			x = list.get(index);
		return x;
	}

	// agrega un elemento al final de la lista del modelo
	public void addElement (E e) {
		list.add(e);
		this.fireIntervalAdded(this, getSize(), getSize());
	}

	// elimina un elemento del modelo que ocupa la posición índice
	public void removeElement (int index) {
		if (index > -1 && index < this.getSize()) {
			list.remove(index);
			this.fireIntervalRemoved(this, index, index);
		}
	}

	// modifica en el modelo los valores del elemento en la posición index
	public void updateElement (int index, E e) {
		if (index > -1 && index < this.getSize()) {
			list.set(index, e);
			this.fireContentsChanged(this, index, index);
		}
	}
}
