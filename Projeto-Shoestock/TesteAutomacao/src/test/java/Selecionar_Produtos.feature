#language: pt
Funcionalidade: Adicionar produtos no carrinho e validar os produtos selecionados
  Como um usuário do Site Shoestock
  Eu quero buscar, incluir produtos no meu carrinho e validar esses produtos na tela de pagamento
  Para garantir que o carrinho contém todos e apenas os produtos que selecionei

  Cenário: Acessar o site da Shoestock, adicionar um produto ao carrinho e validar o produto selecionado
    Dado que acessei o site da Shoestock
    E que quero comprar o produto "Bota Coturno Shoestock Couro Salto Alto Feminina"
    Quando buscar o produto
    E adicionar o produto em meu carrinho
    Então vou realizar o login na minha conta
    E seguir para a tela de pagamento
    E devo validar que os produtos selecionados estão no meu carrinho

  Cenário: Acessar o site da Shoestock, adicionar dois produtos ao carrinho e validar os produtos selecionados
    Dado que acessei o site da Shoestock
    E que quero comprar o produto "Bota Coturno Shoestock Couro Salto Alto Feminina"
    Quando buscar o produto
    E adicionar o produto em meu carrinho
    Dado que quero comprar o produto "Bota Couro Cano Curto Shoestock Correntes Salto Bloco Feminino"
    Quando buscar o produto
    E adicionar o produto em meu carrinho
    Então vou realizar o login na minha conta
    E seguir para a tela de pagamento
    E devo validar que os produtos selecionados estão no meu carrinho
