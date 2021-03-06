/**
 * Script which verifies the free physical memory of the current machine
 *
 * Arguments:
 * required memory (in megabytes)
 */

import com.google.common.base.Strings;
import java.lang.management.ManagementFactory;

if (args.length != 1) {
    println "Incorrect number of arguments, expected 1, received " + args.length;
    selected = false;
    return;
}

requiredMemory = args[0]

if (Strings.isNullOrEmpty(requiredMemory)) {
    println "Given required memory was empty";
    selected = false;
    return;
}

requiredMemory = Double.parseDouble(requiredMemory.trim())

MEGABYTE = (1024L * 1024L);

bean = ManagementFactory.getOperatingSystemMXBean();

freeRAM = ((double) bean.getFreePhysicalMemorySize()) / MEGABYTE;


println "Free physical memory " + freeRAM + "MB (required >= " + requiredMemory + ")";

selected = (freeRAM >= requiredMemory)


