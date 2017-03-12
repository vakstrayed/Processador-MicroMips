# MicroMips-Processador
# Projeto de arquitetura de computadores

O processador implementado tem como tamanho de palavras 32bits.

A memória de instrução inicia-se na posição 0 e é incrementada de 4 em 4;
para refrensentar alocação de 4bytes para as instruções.

As instruções são lidas a partir de um arquivo denominado (entrada.txt),
este arquivo encontra-se acessível na pasta do projeto e pode ser modificado.
Também além da saída no console, é escrito um arquivo de saída (saida.txt).

A memória de dados iniciá-se na posição 8192, também utilizando da representação
de alocação de 4 em 4. O valor da posição da memória pode ser alterado na classe
MemoriaDado, ressaltando que ser for feita alteração, deve-se inserir uma posição
que represente as condições dos 4bytes de alocação.

Através da classe Principal o projeto pode ser executado.
Nele foi implementado a forma de "processador", que utiliza da orientação da
memória de instruções para a execução das instruções lidas do arquivo e
utilizando da memória de dados quando solicitado. E o modo tradutor, que
traduz as instruções, desconsiderando instruções do tipo j, pois este modo
não utiliza a memória de instruções, apenas a memória de dados também quando
solicitado. 


# contém:

Interpretador hexadecimal - mips (32 bits)

metodo de conversão hexa->binário

método de completar string com 0 (32bits)

métodos de completar string com 0 (64 bits)

conversão binário->decimal (retorno inteiro)

conversão binário->decimal (retorno string)

conversão de complemento a dois

