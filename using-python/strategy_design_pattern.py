from __future__ import annotations
from abc import ABC, abstractmethod

class PaymentProcess:
    """This class processes the payment using nested if-else
       such a way that it violates OPEN/CLOSED principle and
       difficult to maintain also
    """
    payment_type = ""

    def set_payment(self, payment_method):
        self.payment_type = payment_method

    def process_payment(self, amount):
        if self.payment_type == "CREDIT CARD":
            print(f"Paying {amount} via CREDIT CARD!")
        elif self.payment_type == "PAYPAL":
            print(f"Paying {amount} via PAYPAL")
        elif self.payment_type == "UPI":
            print(f"Paying {amount} via UPI")
        else:
            raise Exception("Invalid payment type")
        

# Implementing Strategy Design pattern to handle this scenario in elegant way

class PaymentStrategy(ABC):
    """
    This class defines the abstract method to be implemented
    by all the subclasses
    """

    @abstractmethod
    def process_payment(self, amount) -> None:
        pass


class PayingByCreditCard(PaymentStrategy):
    """
    This class implements PaymentStrategy to process the payment
    via credit cards
    """

    def process_payment(self, amount) -> None:
        print(f"Paying {amount} via CREDIT CARD")


class PayingByPaypal(PaymentStrategy):
    """
    This class implements PaymentStrategy to process the payment
    via Paypal
    """

    def process_payment(self, amount) -> None:
        print(f"Paying {amount} via Paypal")


class PayingByUpi(PaymentStrategy):
    """
    This class implements PaymentStrategy to process the payment
    via Paypal
    """

    def process_payment(self, amount) -> None:
        print(f"Paying {amount} via UPI")


class PaymentService():
    """
    Implementing the classes via Composition
    """

    def __init__(self, payment_strategy: PaymentStrategy) -> None:
        self._strategy = payment_strategy

    
    def trigger_payment(self, amount) -> None:
        self._strategy.process_payment(amount)


if __name__ == "__main__":
    payment_service = PaymentService(PayingByCreditCard())
    payment_service.trigger_payment(500)

    payment_service = PaymentService(PayingByPaypal())
    payment_service.trigger_payment(1000)

    payment_service = PaymentService(PayingByUpi())
    payment_service.trigger_payment(2000)