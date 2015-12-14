% Levanto archivos
M = csvread('backtracking.csv');
M = M(:, [1,2,3 ]); % I CONF MEAN_TIME
iMycielBack = M(:,1);
backConf = M(:,2);
backTiempo = M(:,3);

M = csvread('goloso.csv');
M = M(:, [1,2,3 ]); % I CONF MEAN_TIME
iMycielGoloso = M(:,1);
golosoConf = M(:,2);
golosoTiempo = M(:,3);

M = csvread('recoloreo_goloso.csv');
M = M(:, [1,2,3 ]); % I CONF MEAN_TIME
iMycielRecoloreo = M(:,1);
golosoRecoloreoConf = M(:,2);
golosoRecoloreoTiempo = M(:,3);

iMyciel = vertcat(iMycielBack, iMycielRecoloreo, iMycielGoloso);
tiempos = vertcat(backTiempo, golosoRecoloreoTiempo, golosoTiempo)
%conflictos = vertcat(backConf, golosoRecoloreoConf, golosoConf);

G = vertcat(ones(length(backTiempo), 1),  ones(length(golosoRecoloreoTiempo),1)*2, ones(length(golosoTiempo), 1)*3)

ax = subplot(2,1,1);
gscatter(iMyciel, tiempos,G);
hold on;



%set(gca, 'XTick', iMyciel)
title('Tiempo de ejecución (escala logarítmica) según instancia de grafo Mycielski.')
legend('Backtracking', 'Goloso-Recoloreo', 'Goloso');
xlabel('Instancia de grafo Mycielski');
ylabel('Milisegundos');
set(ax,'YScale','log');

ax = subplot(2,1,2);
%gscatter(iMyciel, conflictos,G);

conflictos = horzcat(golosoRecoloreoConf, golosoConf);
bar(iMycielGoloso,conflictos);

%bar(conflictos, G);
%bar(golosoRecoloreoConf);
hold on;

title('Conflictos según instancia de grafo Mycielski.')
legend('Goloso-Recoloreo', 'Goloso');
xlabel('Instancia de grafo Mycielski');
ylabel('Conflictos');
%set(ax,'YScale','log');

% gscatter(n, coeficientes);

