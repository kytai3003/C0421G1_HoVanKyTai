package resort_management.common;

import java.util.Collection;

public interface RepositoryByteStream<T> {
    void writeFile(String path, Collection<T> collection);
    Collection<T> readFile(String path);
}
