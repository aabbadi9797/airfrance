# package 'linearmodel'

C'est un package du modèle linéarire qui utilise la méthode des moindres carrées ordinaires et Ridge, pour faire prédiction
## Installation du package:

```
pip install linearmodel.tar.gz
```

## Pour travailler avec la méthode des moindres carrées:

```
from linearmodel import OrdinaryLaestSquares
```

## Pour travailler avec la régression Ridge:

```
from linearmodel import Ridge
```
#### Attributs
- La class **OrdinaryLaestSquares** contient les attributs **X**, **y**, **Xt**
- La class **Ridge** contient les attributs **X**, **y**, **Xt**, **lambdaRidge**

#### Méthodes
Les deux class notiennent les méthodes: 
- **fit** Calculer l'estimateur
- **predict** faire prediction (prend les Xt) 
- **get_coeffs** les Coeficients estimés (les X)
- **determination_coefficient** R2 le coefficient de détermination

## main.py:
Ce fichier contient le test de 'OrdinaryLaestSquares' avec une BD 'fuel2001' contenant la consommation de carburant entre les 50 états des USA et le district de
Columbia.

![alt text](coef.bmp)
![alt text](pred.bmp)
![alt text](R2.bmp)
