interface PaymentStrategy {
    processPayment(amount): void;
}

class PayingByCreditCard implements PaymentStrategy {
    processPayment(amount: any): void {
        console.info(`Paying ${amount} via CREDIT CARD`)
    }
}

class PayingByPaypal implements PaymentStrategy {
    processPayment(amount: any): void {
        console.info(`Paying ${amount} via PAYPAL`)
    }
}

class PayingByUpi implements PaymentStrategy {
    processPayment(amount: any): void {
        console.info(`Paying ${amount} via UPI`)
    }
}

class PaymentService {
    private paymentStrategy: PaymentStrategy;

    constructor(paymentStrategy: PaymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public triggerPayment(amount: Number) : void {
        this.paymentStrategy.processPayment(amount);
    }
}

let paymentService = new PaymentService(new PayingByCreditCard());
paymentService.triggerPayment(500);

paymentService = new PaymentService(new PayingByPaypal())
paymentService.triggerPayment(1000);

paymentService = new PaymentService(new PayingByUpi())
paymentService.triggerPayment(2000)