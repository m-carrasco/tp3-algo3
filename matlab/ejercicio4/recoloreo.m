
% Levanto archivos
M = csvread('peorCasoVariandoNRecoloreo.csv');
M = M(:, [1, 2, 3, 4]); % N M LC MEAN_TIME
n_recoloreo = M(:,1);
m_recoloreo = M(:,2);
lc_recoloreo = M(:,3);
t_recoloreo = M(:,4);


 subplot(2,1,1);
 gscatter(n_recoloreo, t_recoloreo);
 hold on;
% 
 %set(gca, 'XTick', n)
 title('Tiempo de cómputo (recoloreo) promedio en función de N (C=10, M=O(N^2))')
 legend('Tiempo promedio')
 xlabel('Cantidad de vértices');
 ylabel('Milisegundos');

subplot(2,1,2);
gscatter(n_recoloreo, coeficientes);
%set(gca, 'XTick', n)
title('Cociente entre tiempo y O((n + m)*c) en función de N (C=10, M=O(N^2))')
legend('Cociente')
xlabel('Cantidad de vértices');
ylabel('Milisegundos/cant. op');
