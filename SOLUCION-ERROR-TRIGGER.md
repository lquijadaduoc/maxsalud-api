# 🔧 Solución al Error ORA-04091

## ❌ Problema Identificado

```
ORA-04091: la tabla ADMIN.ERRORES_PROCESO está mutando, 
puede que el disparador/la función no puedan verla
ORA-06512: en "ADMIN.TRG_AUDITORIA_CONSULTAS", línea 3
```

### Causa del Error

El procedimiento almacenado `BUSCAR_PACIENTES_FILTRADOS` tiene un **trigger de auditoría** (`TRG_AUDITORIA_CONSULTAS`) que intenta escribir en la tabla `ERRORES_PROCESO` mientras el procedimiento está ejecutándose. Esto causa una "tabla mutante" que Oracle no permite.

---

## ✅ Soluciones

### **Solución 1: Deshabilitar el Trigger (Recomendado para desarrollo)**

Ejecute este comando SQL en Oracle:

```sql
ALTER TRIGGER ADMIN.TRG_AUDITORIA_CONSULTAS DISABLE;
```

**Ventajas:**
- ✓ Solución rápida e inmediata
- ✓ No afecta la lógica del procedimiento
- ✓ Reversible

**Desventajas:**
- ✗ Se pierde el registro de auditoría
- ✗ Puede no ser apropiado en producción

---

### **Solución 2: Usar Tablas de Auditoría Autónoma**

Modifique el trigger para usar **PRAGMA AUTONOMOUS_TRANSACTION**:

```sql
CREATE OR REPLACE TRIGGER ADMIN.TRG_AUDITORIA_CONSULTAS
AFTER INSERT OR UPDATE OR DELETE ON ADMIN.ERRORES_PROCESO
FOR EACH ROW
DECLARE
    PRAGMA AUTONOMOUS_TRANSACTION;
BEGIN
    -- Lógica de auditoría aquí
    INSERT INTO tabla_auditoria VALUES (...);
    COMMIT;
END;
/
```

**Ventajas:**
- ✓ Mantiene la auditoría funcionando
- ✓ Evita el error de tabla mutante
- ✓ Apropiado para producción

**Desventajas:**
- ✗ Requiere modificar el trigger en Oracle
- ✗ Necesita permisos de DBA

---

### **Solución 3: Eliminar el Trigger (Solo si no es necesario)**

```sql
DROP TRIGGER ADMIN.TRG_AUDITORIA_CONSULTAS;
```

⚠️ **Advertencia:** Solo use esta opción si el trigger de auditoría no es necesario.

---

## 🚀 Pasos para Aplicar la Solución

### Opción A: Desde SQL Developer / SQL*Plus

1. Conectarse a la base de datos como usuario ADMIN
2. Ejecutar:
   ```sql
   ALTER TRIGGER ADMIN.TRG_AUDITORIA_CONSULTAS DISABLE;
   ```
3. Verificar el estado:
   ```sql
   SELECT trigger_name, status 
   FROM user_triggers 
   WHERE trigger_name = 'TRG_AUDITORIA_CONSULTAS';
   ```

### Opción B: Desde Oracle Cloud Console

1. Ir a **SQL Developer Web**
2. Ejecutar el script `fix-trigger.sql`
3. Reintentar la búsqueda desde el frontend

---

## 🔄 Para Revertir (Habilitar nuevamente el trigger)

```sql
ALTER TRIGGER ADMIN.TRG_AUDITORIA_CONSULTAS ENABLE;
```

---

## 📝 Verificación

Después de aplicar la solución, pruebe el endpoint:

```bash
curl "http://localhost:8080/api/reportes/buscar?edadDesde=0&edadHasta=120"
```

O desde PowerShell:

```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/reportes/buscar?edadDesde=0&edadHasta=120"
```

---

## 🎯 Solución Temporal sin Modificar Oracle

Si **NO tiene permisos** para modificar triggers en Oracle, puede usar los endpoints anteriores que sí funcionan:

```
GET /api/reportes/completo
GET /api/reportes/con-descuentos  
GET /api/reportes/morosos
```

Estos endpoints usan el procedimiento `GENERAR_REPORTE_PACIENTES` que no tiene el problema del trigger.

---

## 📧 Contacto con DBA

Si necesita mantener el trigger de auditoría funcionando, contacte al administrador de base de datos (DBA) para implementar la **Solución 2** con PRAGMA AUTONOMOUS_TRANSACTION.

---

**Fecha:** 20 de Octubre, 2025  
**Error:** ORA-04091  
**Archivo de ayuda:** fix-trigger.sql
