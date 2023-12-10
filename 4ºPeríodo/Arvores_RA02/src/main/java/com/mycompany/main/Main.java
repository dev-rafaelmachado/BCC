/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.main;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.concurrent.TimeUnit;

import java.util.Random;

/**
 *
 * @author rafae
 */
public class Main {

    public static final MetricRegistry metrics = new MetricRegistry();

    public static void main(String[] args) {
        Arvore_Normal arvoreNormal = new Arvore_Normal();
        Arvore_AVL arvoreAVL = new Arvore_AVL();

        int quantidade = 20_000;
        testeInsercaoAVL(arvoreAVL, quantidade);

        Gauge<Double> cpuUsage = () -> {
            OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
            return osBean.getSystemLoadAverage();
        };
        metrics.register("cpu_usage", cpuUsage);

        Gauge<Long> memoryUsage = () -> {
            Runtime runtime = Runtime.getRuntime();
            return runtime.totalMemory() - runtime.freeMemory();
        };
        metrics.register("memory_usage", memoryUsage);

        long startTime = System.currentTimeMillis();

        int outroValor = (quantidade * 10) + 1;
        arvoreAVL.inserir(outroValor);
        arvoreAVL.buscar(outroValor);

        long endTime = System.currentTimeMillis();

        // Calcular o tempo decorrido
        long elapsedTime = endTime - startTime;
        System.out.println("Tempo decorrido: " + elapsedTime + " milissegundos");

        ConsoleReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build()
                .report();
    }

    private static void testeInsercaoNormal(Arvore_Normal arvore, int quantidade) {
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            arvore.inserir(random.nextInt(quantidade * 10));
        }
        arvore.inserir(quantidade + 1);
    }

    private static void testeInsercaoAVL(Arvore_AVL arvore, int quantidade) {
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            arvore.inserir(random.nextInt(quantidade * 10));
        }
    }
}
