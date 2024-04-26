package com.coa.project.crudspring.domain.product;

// Um record é uma nova feature introduzida no Java 14 que permite a criação de classes de dados imutáveis de forma concisa.
// Ao contrário das classes tradicionais, que exigem a definição explícita de campos, construtores, métodos equals(), hashCode(), toString() e getters/setters,
// um record pode ser definido em uma única linha, especificando apenas os componentes (fields) que ele deve conter.
// Records são úteis para representar estruturas de dados simples, onde os objetos são imutáveis e têm uma semântica de valor.

// Neste caso, a classe RequestProduct é definida como um record com três componentes: id, name e price.
// Como um record é imutável por padrão, os componentes são final e não podem ser modificados após a criação do objeto.
// Além disso, um record fornece automaticamente métodos equals(), hashCode() e toString() baseados nos seus componentes.
// Também fornece métodos getters para cada componente, permitindo acessar seus valores de forma segura.

public record RequestProduct(String id, String name, double price) {
    
}
