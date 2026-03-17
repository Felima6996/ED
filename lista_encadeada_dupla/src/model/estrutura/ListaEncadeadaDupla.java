package model.estrutura;

import java.lang.Exception; // desnecessário, mas mantido conforme o original
import model.estrutura.No;

public class ListaEncadeadaDupla<T> {

    private No<T> inicio = null;
    private No<T> fim = null;

    // append
    public void append(T elemento) {
        No<T> buffer = new No<>(elemento);
        if (this.fim == null) {
            this.fim = buffer;
            this.inicio = buffer;
        } else {
            No<T> ex_ultimo = this.fim;
            ex_ultimo.setProximo(buffer);
            buffer.setAnterior(ex_ultimo);
            this.fim = buffer;
        }
    }

    // get
    public No<T> get(int index) throws IllegalArgumentException {
        int i = 0;
        if (this.inicio == null)
            throw new IllegalArgumentException("Nao existe item na lista.");

        No<T> buffer = this.inicio;
        for (i = 0; i < index; i++) {
            if (buffer.getProximo() == null)
                break;
            buffer = buffer.getProximo();
        }
        if (i < index)
            throw new IllegalArgumentException("O indice informado nao existe");

        return buffer;
    }

    // index
    public int index(T elemento) throws IllegalArgumentException {
        if (this.inicio == null)
            throw new IllegalArgumentException("Nao existe item na lista.");

        int idx = 0;
        if (this.inicio.getValor() == elemento)
            return idx;

        No<T> buffer = this.inicio;
        do {
            if (buffer.getValor() == elemento) {
                return idx;
            }
            buffer = buffer.getProximo();
            idx++;
        } while (buffer != null);

        throw new IllegalArgumentException("Item nao encontrado.");
    }

    // insert(int, T)
    public void insert(int index, T elemento) throws IllegalArgumentException {
        if (index == 0) {
            No<T> novo = new No<>(elemento);
            if (this.inicio == null) {
                this.inicio = novo;
                this.fim = novo;
            } else {
                No<T> ex_inicio = this.inicio;
                novo.setProximo(ex_inicio);
                this.inicio = novo;
                ex_inicio.setAnterior(novo);
                novo.setAnterior(null); // linha 80 removida (estava errada) + correção necessária
            }
        } else {
            this.insert(this.get(--index), elemento);
        }
    }

    // insert(No<T>, T) - sobrecarga
    public void insert(No<T> item, T elemento) throws IllegalArgumentException {
        No<T> novo = new No<>(elemento);
        No<T> proximo = item.getProximo();

        novo.setProximo(proximo);
        item.setProximo(novo);
        novo.setAnterior(item);

        if (proximo != null) {
            proximo.setAnterior(novo);
        } else {
            this.fim = novo; // correção necessária para inserir no final
        }
    }

    // prepend
    public void prepend(T elemento) {
        No<T> buffer = new No<>(elemento);
        if (this.fim == null) {
            this.fim = buffer;
            this.inicio = buffer;
        } else {
            No<T> ex_primeiro = this.inicio;
            this.inicio = buffer;
            buffer.setProximo(ex_primeiro);
            ex_primeiro.setAnterior(buffer);
        }
    }

    // remove
    public void remove(int index) {
        if (index == 0) {
            this.inicio.setValor(null);
            if (this.inicio.getProximo() == null) {
                this.inicio = null;
                this.fim = null;
            } else {
                No<T> buffer = this.inicio.getProximo();
                this.inicio.setProximo(null);
                this.inicio = buffer;
                this.inicio.setAnterior(null); // correção solicitada (entre linhas 122-123)
            }
            return;
        }

        No<T> anterior = this.get(index - 1);
        No<T> item = anterior.getProximo();
        No<T> proximo = item.getProximo();

        anterior.setProximo(proximo);
        if (proximo != null) {
            proximo.setAnterior(anterior);
        } else {
            this.fim = anterior; // correção necessária ao remover o último
        }
        item.setAnterior(null);
        item.setValor(null);
        // proximo.setAnterior(anterior); e item.setAnterior(null); adicionados conforme nota
    }

    // total
    public int total() {
        if (this.inicio == null)
            return 0;

        No<T> buffer = this.inicio;
        int total_elementos = 0;
        do {
            total_elementos++;
            buffer = buffer.getProximo();
        } while (buffer != null);

        return total_elementos;
    }

    // toString
    @Override
    public String toString() {
        if (this.inicio == null) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        No<T> buffer = this.inicio;
        while (buffer.getProximo() != null) {
            builder.append(buffer.getValor());
            builder.append(", ");
            buffer = buffer.getProximo();
        }
        builder.append(buffer.getValor());
        builder.append("]");
        return builder.toString();
    }
}