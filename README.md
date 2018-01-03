# XY-Inc
*Plataforma que fornece inteligencia para um software que auxilia pessoas na localização de ponto de interesse (POIs)*

 **Ferramentas para desenvolvimento**
	 1. NetBeans
	 2. GitHub
	 3. [ini4j ](http://ini4j.sourceforge.net/)


# Imagens
**Imports**
![Item](https://i.imgur.com/bmyz5Qj.png)
**Listas para organizar as coordenadas como itens**
![Item](https://i.imgur.com/5oZ7Anq.png)
**Adicionando item na lista**
![Item](https://i.imgur.com/V3Nngzy.png)
**Exportando os items para um arquivo .ini**
![Item](https://i.imgur.com/SggOSIs.png)
**Modelo de arquivo .ini**
![Item](https://i.imgur.com/hmrvHd7.png)
**Leitura do arquivo .ini e importando os items**
![Item](https://i.imgur.com/Axx115w.png)
**Função para encontrar os POIs mais próximos**
![Item](https://i.imgur.com/AO3PFlf.png)
# Arquivo INI
**Chave Config**
Disponibiliza a quantidade total de coordenadas disponíveis, através da seção CordsTotal.
**Outras chaves**
As outras chaves são numeradas de 0 Até CordsTotal - 1, e dentro possui as seções
 1. Local(Nome do local)
 2. CordX(Coordenada X)
 3. CordY(Coordenada Y)

*Padrão das chaves*
[Numero de zero á CordsTotal - 1]
Local =  Nome
CordX = CoordenadaX
CordY = CoordenadaY
