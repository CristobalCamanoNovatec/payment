package com.gluon.payment.payment.infraestructure.adapters.in;

import com.gluon.payment.payment.application.ports.in.SendPaymentIn;
import com.gluon.payment.payment.domain.exception.BusinessException;
import com.gluon.payment.payment.domain.gluon.GluonRequest;
import com.gluon.payment.payment.domain.gluon.GluonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("{payment-path}")
@Tag(name ="Payment", description = "Api encargada de los pagos")
public class PaymentController {

    private final SendPaymentIn payment;

    public PaymentController(SendPaymentIn payment) {
    this.payment=payment;
}

    @Operation(summary = "Pagos", description = "Esta api se encarga de recibir una petición con formato GLUON y consumir a Altair para generar un pago",
            operationId = "Operacion id", method = "Metodo X")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema =     @Schema(implementation = GluonResponse.class),
                            examples = @ExampleObject(name = "Ejemplo 1",
                                    value = "{\"payment\":{\"payer\":{\"origin\":{\"account\":\"accountId\"}}}}",
                                    description = "Para la respuesta exitosa se retornas los datos account Id que hace referencia a la cuenta del cliente",
                            summary = "Ejemplo 1",
                            externalValue = "Ejemplo externo"))),
            @ApiResponse(responseCode = "404", description = "Error controlado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class),
                            examples = @ExampleObject(name = "Error controlado",
                                    value = "Error en los datos de ebtrada"))),
            @ApiResponse(responseCode = "500", description = "Error del servidor",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class),
                            examples = @ExampleObject(name = "Error del servidor",
                                    value = "Error en el servidor, Por favor intentar mas tarde o comunicarse con el administrador")))
    })
    @ResponseBody
    @PostMapping("/")
    public ResponseEntity<String> sendPayment(@RequestBody GluonRe  quest gluon) {
        try {
            String message = payment.sendPayment(gluon);
            return ResponseEntity.status(HttpStatus.OK).body(message.toString());
        } catch (BusinessException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage().toString());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.toString());
        }
    }
}


