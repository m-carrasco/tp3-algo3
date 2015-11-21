% Levanto archivos
M = csvread('variandoC.csv');
M = M(:, [1,2,3, 4 ]); % N M LC MEAN_TIME
n = M(:,1);
m = M(:,2);
lc = M(:,3);
t = M(:,4);

%x_peor, y_peor, x_mejor, y_mejor todos tienen mismos tamaños.

coeficientes = ones(length(n), 1);
for j=1:length(n)
    coeficientes(j) = (t(j)) / (lc(j)*lc(j));
end

subplot(2,1,1);
gscatter(lc, t);
hold on;

set(gca, 'XTick', lc)
title('Tiempo de cómputo promedio en función de C (N=250 y M=50)')
legend('Tiempo promedio de cómputo O(c^2)')
xlabel('Cantidad máxima de colores para un nodo');
ylabel('Milisegundos');

subplot(2,1,2);
gscatter(lc, coeficientes);

set(gca, 'XTick', lc)
title('Cociente entre tiempo de computo y complejidad temporal en función de C (N=250 y M=50)')
legend('Cociente')
xlabel('Cantidad máxima de colores para un nodo');
ylabel('Milisegundos/cant. op');