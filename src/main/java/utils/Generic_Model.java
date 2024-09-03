package utils;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class Generic_Model<E> extends AbstractListModel {
	private ArrayList<E> list = new ArrayList<E>();

	// actualiza la vista
	public void refresh() {
		this.fireIntervalAdded(this, 0, getSize());
	}

	// establece la lista de elementos en el modelo
	public void setList(ArrayList<E> list) {
		this.list = list;
		this.fireIntervalAdded(this, 0, getSize());
	}

	// devuelve el tamaño de la lista del modelo
	public int getSize() {
		return list.size();
	}

	// devuelve el elemento de la posición index dentro del modelo
	public E getElementAt(int indice) {
		E x = null;
		if (indice > -1 && indice < this.getSize())
			x = list.get(indice);
		return x;
	}

	// agrega un elemento al final de la lista del modelo
	public void addElement (E e) {
		list.add(e);
		this.fireIntervalAdded(this, getSize(), getSize());
	}

	// elimina un elemento del modelo que ocupa la posición índice
	public void removeElement (int indice) {
		if (indice > -1 && indice < this.getSize()) {
			list.remove(indice);
			this.fireIntervalRemoved(this, indice, indice);
		}
	}

	// modifica en el modelo los valores del elemento en la posición indice
	public void updateElement (int indice, E e) {
		if (indice > -1 && indice < this.getSize()) {
			list.set(indice, e);
			this.fireContentsChanged(this, indice, indice);
		}
	}
}
