package general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ListenerUtils<ListenerType> implements Iterable<ListenerType> {
    private final List<ListenerType> _listeners = new ArrayList<>();

    public void add(final ListenerType listener) {
        _listeners.add(listener);
    }

    public void remove(final ListenerType listener) {
        _listeners.remove(listener);
    }

    @Override
    public Iterator<ListenerType> iterator() {
        return _listeners.iterator();
    }
}
