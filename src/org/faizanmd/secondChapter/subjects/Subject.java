package org.faizanmd.secondChapter.subjects;

import org.faizanmd.secondChapter.observers.Observer;

public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
