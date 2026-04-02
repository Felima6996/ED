package model.estrutura;

import java.lang.Exception;
import model.estrutura.No;

public class FilaFifo<T> {
    private No<T> inicio = null;

    // A ideia do last() é percorrer do início até o elemento que o próximo é null.
    public No<T> last() throws IllegalArgumentException {
        if (this.inicio == null) {
            throw new IllegalArgumentException("Nao existe fila.");
        }
        No<T> buffer = this.inicio;
        while (buffer.getProximo() != null) {
            buffer = buffer.getProximo();
        }
        return buffer;
    }

    public void enqueue(T elemento) {
        No<T> buffer = new No<>(elemento);
        if (this.inicio == null) {
            this.inicio = buffer;
        } else {
            this.last().setProximo(buffer);
        }
    }

    public No<T> dequeue() {
        if (this.inicio == null) {
            return null;
        }
        No<T> primeiro = this.inicio;
        this.inicio = primeiro.getProximo();
        return primeiro;
    }

    @Override
    public String toString() {
        if (this.inicio == null) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        No<T> buffer = this.inicio;
        builder.append(buffer.getValor());
        
        while (buffer.getProximo() != null) {
            builder.append(",");
            buffer = buffer.getProximo();
            builder.append(buffer.getValor());
        }
        
        builder.append("]");
        return builder.toString();
    }
}