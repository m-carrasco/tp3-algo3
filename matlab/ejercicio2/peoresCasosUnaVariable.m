% Levanto archivos
M = csvread('variandoNPeorCaso.csv');
M = M(:, [1, 2, 3]); % N LC MEAN_TIME
n = M(:,1);

t = M(:,3);

%x_peor, y_peor, x_mejor, y_mejor todos tienen mismos tamaños.

coeficientes = ones(length(n), 1);
for j=1:length(n)
    coeficientes(j) = (t(j)) / ((n(j)^2)*(3^n(j)));
end

subplot(2,2,1);
gscatter(n, t);
hold on;

set(gca, 'XTick', n)
title('Tiempo de cómputo promedio en función de N (C=6)')
legend('Tiempo promedio para peor caso: O(n^2 3^n)')
xlabel('Cantidad de vértices');
ylabel('Milisegundos');

subplot(2,2,2);
gscatter(n, coeficientes);
set(gca, 'XTick', n)
title('Cociente entre tiempo y O(n^2 3^n) en función de N (C=6)')
legend('Cociente')
xlabel('Cantidad de vértices');
ylabel('Milisegundos/cant. op');


% Levanto archivos
M = csvread('variandoLCPeorCaso.csv');
M = M(:, [1, 2, 3]); % N LC MEAN_TIME
n = M(:,1);
lc = M(:,2);
t = M(:,3);

%x_peor, y_peor, x_mejor, y_mejor todos tienen mismos tamaños.

coeficientes = ones(length(n), 1);
for j=1:length(n)
    coeficientes(j) = (t(j)) / ((5^2)*(lc(j)^5));
end

subplot(2,2,3);
gscatter(lc, t);
hold on;

set(gca, 'XTick', lc)
title('Tiempo de cómputo promedio en función de C (N=5)')
legend('Tiempo promedio para peor caso: O(C^5)')
xlabel('Cantidad máxima de colores disponibles para un vértice');
ylabel('Milisegundos');

subplot(2,2,4);
gscatter(lc, coeficientes);
set(gca, 'XTick', lc)
title('Cociente entre tiempo y O(C^5) en función de C (N=5)')
legend('Cociente')
xlabel('Cantidad máxima de colores disponibles para un vértice');
ylabel('Milisegundos/cant. op');



% 
% % unimos datos.
% x = vertcat(x_peor, x_sinintencionalidad, x_me
% y = vertcat(y_peor, y_sinintencionalidad, y_mejor);
% G = vertcat(ones(length(x_peor),1)*1, ones(length(x_sinintencionalidad), 1)*2, ones(length(x_mejor), 1)*3);
% subplot(2,1,1);
% gscatter(x, y, G);
% set(gca, 'XTick', x_peor)
% title('Tiempo de computo promedio')
% legend('Caso Peor', 'Caso Sin Intencionalidad', 'Caso Mejor')
% xlabel('Tamano de entrada en funcion de N (L=N-1, P = N)');
% ylabel('Milisegundos');
% 
% % Hacemos cociente entre el tiempo promedio y la cantidad de operaciones.
% 
% 
% for j=1:length(y_peor)
%     p = (x_peor(j)+1)*(x_peor(j)+1);
%     y_peor(j) = y_peor(j)/p;    
%     y_sinintencionalidad(j) = y_sinintencionalidad(j)/ p;
%     y_mejor(j) = y_mejor(j) / p;
% end
% 
% % unimos datos.
% x = vertcat(x_peor, x_sinintencionalidad, x_mejor);
% y = vertcat(y_peor, y_sinintencionalidad, y_mejor);;
% 
% % Agrupamos los datos a graficar, los primeros son de mejor y los segundos
% % de peor
% G = vertcat(ones(length(x_peor), 1)*1, ones(length(x_peor), 1)*2, ones(length(x_sinintencionalidad), 1)*3);
% 
% % graficamos los puntos
% subplot(2,1,2);
% gscatter(x, y, G);
% hold on;
% 
% set(gca, 'XTick', x_peor)
% title('Relacion entre tiempo de computo promedio y cota dada por O(N*L+P)')
% legend('Caso Peor', 'Caso Sin Intencionalidad', 'Caso Mejor')
% %legend('Peor Caso', 'Sin Intencionalidad')
% xlabel('Tamano de entrada en funcion de N (L=N-1, P = N)');
% ylabel('Milisegundos / cant. operaciones');
